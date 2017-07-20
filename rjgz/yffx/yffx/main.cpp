#include<iostream>
#include<string>
using namespace std;

char prog[80], token[8];
char ch;
int syn, p, m, n, sum;
int kk = 0, ii, N, nn = 0;
int k = 0, t, i = 0;
char tt;
char * keywords[6] = { "begin", "if", "then", "while", "do", "end" }; //关键字表
int scaner();
int parser();
int statement();
int sentence();
char *term();
char *factor();
char *expression();
void emit(char *result, char *ag1, char *op, char *ag2);
struct//四元式的结构
{
	char resulted[8];
	char ag1ed[8];
	char oped[8];
	char ag2ed[8];
}quad[20];

void main()
{
	p = 0;
	cout << "请输入字符串，以#号结束: " << endl;
	while (ch != '#')
	{
		cin >> ch;
		prog[p++] = ch;
	}
	p = 0;
	scaner();
	parser();
}

char * newtemp(void) //返回一个新的临时变量名,临时变量名产生的顺序为t1,t2,…
{
	char * P;
	char M[8];
	P = (char *)malloc(8);
	k++;
	itoa(k, M,10);
	strcpy(P + 1, M);
	P[0] = 't';
	return(P);
}

int parser()//将输入串翻译成四元式序列。只对表达式、赋值语句进行翻译
{
	int schain = 0;
	kk = 0;
	if (syn == 1)
	{
		scaner();
		schain = sentence(); //调用语句串分析函数进行分析
		if (syn = 6) 
		{
			scaner();
			if (syn == 0 && (kk == 0))
				cout << "success" << endl;
		}
		else
		{
			if (kk != 1)
				cout << "缺end错误" << endl;
			kk = 1;
		}
	}
	else
	{
		cout << "begin错误" << endl;
		kk = 1;
	}
	return(schain);
}

int sentence() //语句串分析函数
{
	int schain = 0;
	schain = statement();//调用语句分析函数进行分析
	while (syn == 26)
	{
		scaner();
		schain = statement();//调用语句分析函数进行分析
	}
	return(schain);
}
int statement()//语句分析函数
{
	char tt[8], eplace[8];
	int schain = 0;
	switch (syn)
	{
	case 10:
		strcpy(tt, token);
		scaner();
		if (syn == 18) //赋值语句  
		{
			scaner();
			strcpy(eplace, expression());
			emit(tt, eplace, "", "");
			schain = 0;
		}
		else
		{
			cout << "缺少赋值号" << endl; //缺少":="错误
			kk = 1;
		}
		return(schain);
		break;
	}
}

char * expression(void)
{
	char * tp, *ep2, *eplace, *tt;
	tp = (char *)malloc(12);//分配空间
	ep2 = (char *)malloc(12);
	eplace = (char *)malloc(12);
	tt = (char *)malloc(12);
	strcpy(eplace, term());//调用term分析产生表达式计算的第一项 eplace
	while (syn == 13 || syn == 14) //加减。 
	{
		strcpy(tt, token);
		scaner();
		strcpy(ep2, term());//调用term()分析产生表达式计算的第二项 ep2
		strcpy(tp, newtemp());//调用newtemp()产生临时变量tp存储计 算结果
		emit(tp, eplace, tt, ep2);//生成四元式送入四元式表
		strcpy(eplace, tp);
	}
	return(eplace);
}

char * term(void)
{
	char * tp, *ep2, *eplace, *tt;
	tp = (char *)malloc(12);
	ep2 = (char *)malloc(12);
	eplace = (char *)malloc(12);
	tt = (char *)malloc(12);
	strcpy(eplace, factor());
	while (syn == 15 || syn == 16) //乘除
	{
		strcpy(tt, token);
		scaner();
		strcpy(ep2, factor());
		strcpy(tp, newtemp());
		emit(tp, eplace, tt, ep2);
		strcpy(eplace, tp);
	}
	return(eplace);
}

char * factor(void)
{
	char * fplace;
	fplace = (char *)malloc(12);
	strcpy(fplace, " ");
	if (syn == 10)//字母
	{
		strcpy(fplace, token);
		scaner();
	}
	else if (syn == 11)//数字
	{
		itoa(sum, fplace, 10);
		scaner();
	}
	else if (syn == 27)
	{
		scaner();
		strcpy(fplace, expression());
		if (syn == 28)
			scaner();
		else
		{
			cout << "')'错误" << endl;
			kk = 1;
		}
	}
	else
	{
		cout << "'('错误" << endl;
		kk = 1;
	}
	return(fplace);
}

void emit(char * result, char * ag1, char * op, char * ag2)//生成一个三地址码并返回到四元式代码中
{
	strcpy(quad[nn].resulted, result);
	strcpy(quad[nn].ag1ed, ag1);
	strcpy(quad[nn].oped, op);
	strcpy(quad[nn].ag2ed, ag2);
	cout << nn + 1 << "  " << quad[nn].resulted << "=" << quad[nn].ag1ed << quad[nn].oped << quad[nn].ag2ed << endl;
	nn++;
}
int scaner()//此函数为词法分析。  
{
	for (n = 0; n<8; n++) token[n] = NULL;
	ch = prog[p++];
	m = 0;
	while (ch == ' ')
		ch = prog[p++];
	if ((ch >= 'a') && (ch <= 'z')) //判断是否是字母  
	{
		while ((ch >= 'a') && (ch <= 'z') || (ch >= '0') && (ch <= '9')) //判断下一个是否是字母或数字
		{
			token[m++] = ch;
			ch = prog[p++];
		}
		token[m++] = '\0';
		p--;
		syn = 10;
		for (n = 0; n<6; n++)
		if (strcmp(token, keywords[n]) == 0) //判断是否匹配关键字
		{
			syn = n + 1;
			break;
		}
	}
	else if (ch >= '0' && ch <= '9') //判断数字  
	{
		sum = 0;
		while ((ch >= '0') && (ch <= '9')) //判断下一个是否是数字
		{
			sum = sum * 10 + (int)ch - '0';
			ch = prog[p++];
		}
		p--;
		syn = 11;
	}
	else
		switch (ch)
	{
		case'<'://是否是"<"   
			m = 0;
			token[m++] = ch;
			if (ch == '>') //是否是">"
			{
				syn = 21;
				token[m++] = ch;
			}
			else if (ch == '=')//判断下一个是否是"="，即为判断符号"<="
			{
				syn = 22;
				token[m++] = ch;
			}
			else
			{
				syn = 20;
				ch = prog[p++];
			}
			break;
		case'>':  //是否是">"
			m = 0;
			token[m++] = ch;
			ch = prog[p++];
			if (ch == '=')//判断下一个是否是"="，即为判断符号">="   
			{
				syn = 24;
				token[m++] = ch;
			}
			else
			{
				syn = 23;
				p--;
				break;
			}
			break;
		case':': //是否是":"
			m = 0;
			token[m++] = ch;
			ch = prog[p++];
			if (ch == '=') //判断下一个是否是"="，即为判断符号":="
			{
				syn = 18;
				token[m++] = ch;
			}
			else
			{
				syn = 17;
				p--;
			}
			break;
		case'+':
			syn = 13;
			token[0] = ch;
			break; //判断符号"+"
		case'-':
			syn = 14;
			token[0] = ch;
			break; //判断符号"-"
		case'*':
			syn = 15;
			token[0] = ch;
			break; //判断符号"*"   
		case'/':
			syn = 16;
			token[0] = ch;
			break; //判断符号"=" 
		case'=':
			syn = 25;
			token[0] = ch;
			break; //判断符号";"   
		case';':
			syn = 26;
			token[0] = ch;
			break; //判断符号"+"    
		case'(':
			syn = 27;
			token[0] = ch;
			break;//判断符号"("
		case')':
			syn = 28;
			token[0] = ch;
			break;//判断符号")"    
		case'#':
			syn = 0;
			token[0] = ch;
			break;//判断符号"#"
		default:
			syn = -1;
	}
	return syn;
}