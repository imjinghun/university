#include<iostream>
#include<string>
using namespace std;

char prog[80], token[8];
char ch;
int syn, p, m, n, sum;
int kk = 0, ii, N, nn = 0;
int k = 0, t, i = 0;
char tt;
char * keywords[6] = { "begin", "if", "then", "while", "do", "end" }; //�ؼ��ֱ�
int scaner();
int parser();
int statement();
int sentence();
char *term();
char *factor();
char *expression();
void emit(char *result, char *ag1, char *op, char *ag2);
struct//��Ԫʽ�Ľṹ
{
	char resulted[8];
	char ag1ed[8];
	char oped[8];
	char ag2ed[8];
}quad[20];

void main()
{
	p = 0;
	cout << "�������ַ�������#�Ž���: " << endl;
	while (ch != '#')
	{
		cin >> ch;
		prog[p++] = ch;
	}
	p = 0;
	scaner();
	parser();
}

char * newtemp(void) //����һ���µ���ʱ������,��ʱ������������˳��Ϊt1,t2,��
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

int parser()//�����봮�������Ԫʽ���С�ֻ�Ա��ʽ����ֵ�����з���
{
	int schain = 0;
	kk = 0;
	if (syn == 1)
	{
		scaner();
		schain = sentence(); //������䴮�����������з���
		if (syn = 6) 
		{
			scaner();
			if (syn == 0 && (kk == 0))
				cout << "success" << endl;
		}
		else
		{
			if (kk != 1)
				cout << "ȱend����" << endl;
			kk = 1;
		}
	}
	else
	{
		cout << "begin����" << endl;
		kk = 1;
	}
	return(schain);
}

int sentence() //��䴮��������
{
	int schain = 0;
	schain = statement();//�����������������з���
	while (syn == 26)
	{
		scaner();
		schain = statement();//�����������������з���
	}
	return(schain);
}
int statement()//����������
{
	char tt[8], eplace[8];
	int schain = 0;
	switch (syn)
	{
	case 10:
		strcpy(tt, token);
		scaner();
		if (syn == 18) //��ֵ���  
		{
			scaner();
			strcpy(eplace, expression());
			emit(tt, eplace, "", "");
			schain = 0;
		}
		else
		{
			cout << "ȱ�ٸ�ֵ��" << endl; //ȱ��":="����
			kk = 1;
		}
		return(schain);
		break;
	}
}

char * expression(void)
{
	char * tp, *ep2, *eplace, *tt;
	tp = (char *)malloc(12);//����ռ�
	ep2 = (char *)malloc(12);
	eplace = (char *)malloc(12);
	tt = (char *)malloc(12);
	strcpy(eplace, term());//����term�����������ʽ����ĵ�һ�� eplace
	while (syn == 13 || syn == 14) //�Ӽ��� 
	{
		strcpy(tt, token);
		scaner();
		strcpy(ep2, term());//����term()�����������ʽ����ĵڶ��� ep2
		strcpy(tp, newtemp());//����newtemp()������ʱ����tp�洢�� ����
		emit(tp, eplace, tt, ep2);//������Ԫʽ������Ԫʽ��
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
	while (syn == 15 || syn == 16) //�˳�
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
	if (syn == 10)//��ĸ
	{
		strcpy(fplace, token);
		scaner();
	}
	else if (syn == 11)//����
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
			cout << "')'����" << endl;
			kk = 1;
		}
	}
	else
	{
		cout << "'('����" << endl;
		kk = 1;
	}
	return(fplace);
}

void emit(char * result, char * ag1, char * op, char * ag2)//����һ������ַ�벢���ص���Ԫʽ������
{
	strcpy(quad[nn].resulted, result);
	strcpy(quad[nn].ag1ed, ag1);
	strcpy(quad[nn].oped, op);
	strcpy(quad[nn].ag2ed, ag2);
	cout << nn + 1 << "  " << quad[nn].resulted << "=" << quad[nn].ag1ed << quad[nn].oped << quad[nn].ag2ed << endl;
	nn++;
}
int scaner()//�˺���Ϊ�ʷ�������  
{
	for (n = 0; n<8; n++) token[n] = NULL;
	ch = prog[p++];
	m = 0;
	while (ch == ' ')
		ch = prog[p++];
	if ((ch >= 'a') && (ch <= 'z')) //�ж��Ƿ�����ĸ  
	{
		while ((ch >= 'a') && (ch <= 'z') || (ch >= '0') && (ch <= '9')) //�ж���һ���Ƿ�����ĸ������
		{
			token[m++] = ch;
			ch = prog[p++];
		}
		token[m++] = '\0';
		p--;
		syn = 10;
		for (n = 0; n<6; n++)
		if (strcmp(token, keywords[n]) == 0) //�ж��Ƿ�ƥ��ؼ���
		{
			syn = n + 1;
			break;
		}
	}
	else if (ch >= '0' && ch <= '9') //�ж�����  
	{
		sum = 0;
		while ((ch >= '0') && (ch <= '9')) //�ж���һ���Ƿ�������
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
		case'<'://�Ƿ���"<"   
			m = 0;
			token[m++] = ch;
			if (ch == '>') //�Ƿ���">"
			{
				syn = 21;
				token[m++] = ch;
			}
			else if (ch == '=')//�ж���һ���Ƿ���"="����Ϊ�жϷ���"<="
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
		case'>':  //�Ƿ���">"
			m = 0;
			token[m++] = ch;
			ch = prog[p++];
			if (ch == '=')//�ж���һ���Ƿ���"="����Ϊ�жϷ���">="   
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
		case':': //�Ƿ���":"
			m = 0;
			token[m++] = ch;
			ch = prog[p++];
			if (ch == '=') //�ж���һ���Ƿ���"="����Ϊ�жϷ���":="
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
			break; //�жϷ���"+"
		case'-':
			syn = 14;
			token[0] = ch;
			break; //�жϷ���"-"
		case'*':
			syn = 15;
			token[0] = ch;
			break; //�жϷ���"*"   
		case'/':
			syn = 16;
			token[0] = ch;
			break; //�жϷ���"=" 
		case'=':
			syn = 25;
			token[0] = ch;
			break; //�жϷ���";"   
		case';':
			syn = 26;
			token[0] = ch;
			break; //�жϷ���"+"    
		case'(':
			syn = 27;
			token[0] = ch;
			break;//�жϷ���"("
		case')':
			syn = 28;
			token[0] = ch;
			break;//�жϷ���")"    
		case'#':
			syn = 0;
			token[0] = ch;
			break;//�жϷ���"#"
		default:
			syn = -1;
	}
	return syn;
}