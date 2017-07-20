#include<iostream>
#include<string>
using namespace std;

char a[50], b[50], d[500], e[10];
char ch;
int n1, i1 = 0, flag = 1, n = 5;
int E();
int E1();
int T();
int G();
int S();
int F();

void output();
void output1();
void input();

void main() //µİ¹é·ÖÎö
{
	int f, p, j = 0;
	char x;
	d[0] = 'E';
	d[1] = '=';
	d[2] = '>';
	d[3] = 'T';
	d[4] = 'G';
	d[5] = '#';
	cout << "ÇëÊäÈë×Ö·û´®,ÒÔ#½áÊø" << endl;
	while (ch != '#')
	{
		cin >> ch;
		a[j] = ch;
		j++;
	}
	n1 = j;
	ch = b[0] = a[0];
	cout << "ÎÄ·¨\t·ÖÎö´®\t\t\t·ÖÎö×Ö·û\t\tÊ£Óà´®\n" << endl;
	f = E1();
	if (f == 0) return;
	if (ch == '#')
	{
		cout << "accept\n";
		p = 0;
		x = d[p];
		while (a[p] != '#')
			cout << a[p++];
		cout << "×Ö·ûºÏ·¨!\n";
	}
	else
	{
		j = 0;
		while (a[j] != '#')
			cout << a[j++];
		cout << "×Ö·û·Ç·¨!\n";
		getchar(); getchar();
		return;
	}
	getchar();
	getchar();
}

int E1()
{
	int f, t;
	cout << "E-->TG\t";
	flag = 1;
	output();
	output1();
	f = T();
	if (f == 0)
		return(0);
	t = G();
	if (t == 0)
		return(0);
	else
		return(1);
}

int E()
{
	int f, t;
	cout << "E-->TG\t";
	e[0] = 'E';
	e[1] = '=';
	e[2] = '>';
	e[3] = 'T';
	e[4] = 'G';
	e[5] = '#';
	input();
	flag = 1;
	output();
	output1();
	f = T();
	if (f == 0)
		return(0);
	t = G();
	if (t == 0)
		return(0);
	else
		return(1);
}

int T()
{
	int f, t;
	cout << "T-->FS\t";
	e[0] = 'T';
	e[1] = '=';
	e[2] = '>';
	e[3] = 'F';
	e[4] = 'S';
	e[5] = '#';
	input();
	flag = 1;
	output();
	output1();
	f = F();
	if (f == 0)
		return(0);
	t = S();
	if (t == 0)
		return(0);
	else
		return(1);
}

int G()
{
	int f;
	if (ch == '+')
	{
		b[i1] = ch;
		cout << "G-->+TG\t";
		e[0] = 'G';
		e[1] = '=';
		e[2] = '>';
		e[3] = '+';
		e[4] = 'T';
		e[5] = 'G';
		e[6] = '#';
		input();
		flag = 0;
		output();
		output1();
		ch = a[++i1];
		f = T();
		if (f == 0)
			return(0);
		f = G();
		if (f == 0)
			return 0;
		else
			return 1;
	}
	else if (ch == '-')
	{
		b[i1] = ch;
		cout << "G-->-TG\t";
		e[0] = 'G';
		e[1] = '=';
		e[2] = '>';
		e[3] = '-';
		e[4] = 'T';
		e[5] = 'G';
		e[6] = '#';
		input();
		flag = 0;
		output();
		output1();
		ch = a[++i1];
		f = T();
		if (f == 0)
		{
			return(0);
		}
		f = G();
		if (f == 0)
			return 0;
		else
			return 1;
	}
	else
	{
		cout << "G-->^\t";
		e[0] = 'G';
		e[1] = '=';
		e[2] = '>';
		e[3] = '^';
		e[4] = '#';
		input();
		flag = 1;
		output();
		output1();
		return(1);
	}

}

int S()
{
	int f, t;
	if (ch == '*')
	{
		b[i1] = ch;
		cout << "S-->*FS\t";
		e[0] = 'S';
		e[1] = '=';
		e[2] = '>';
		e[3] = '*';
		e[4] = 'F';
		e[5] = 'S';
		e[6] = '#';
		input();
		flag = 0;
		output();
		output1();
		ch = a[++i1];
		f = F();
		if (f == 0)
			return(0);
		t = S();
		if (t == 0)
			return(0);
		else
			return(1);
	}
	else if (ch == '/')
	{
		b[i1] = ch;
		cout << "S-->/FS\t";
		e[0] = 'S';
		e[1] = '=';
		e[2] = '>';
		e[3] = '/';
		e[4] = 'F';
		e[5] = 'S';
		e[6] = '#';
		input();
		flag = 0;
		output();
		output1();
		ch = a[++i1];
		f = F();
		if (f == 0)
			return(0);
		t = S();
		if (t == 0)
			return(0);
		else
			return(1);
	}
	else
	{
		cout << "S-->^\t";
		e[0] = 'S';
		e[1] = '=';
		e[2] = '>';
		e[3] = '^';
		e[4] = '#';
		input();
		flag = 1;
		a[i1] = ch;
		output();
		output1();
		return(1);
	}
}

int F()
{
	int f;
	int j;
	if (ch == '(')
	{
		b[i1] = ch;
		cout << "F-->(E)\t";
		e[0] = 'F';
		e[1] = '=';
		e[2] = '>';
		e[3] = '(';
		e[4] = 'E';
		e[5] = ')';
		e[6] = '#';
		input();
		flag = 0;
		output();
		output1();
		ch = a[++i1];
		f = E();
		if (f == 0)
			return(0);
		if (ch == ')')
		{
			b[i1] = ch;
			cout << "F-->(E)\t";
			flag = 0;
			output();
			output1();
			ch = a[++i1];
		}
		else
		{
			cout << "error\n";
			j = 0;
			while (a[j] != '#')
				cout << a[j++];
			cout << "×Ö·û·Ç·¨!\n";
			return(0);
		}
	}
	else if (ch == 'i')
	{
		b[i1] = ch;
		cout << "F-->i\t";
		e[0] = 'F';
		e[1] = '=';
		e[2] = '>';
		e[3] = 'i';
		e[4] = '#';
		input();
		flag = 0;
		output();
		output1();
		ch = a[++i1];
	}
	else
	{
		cout << "error\n";
		j = 0;
		while (a[j] != '#')
			cout << a[j++];
		cout << "×Ö·û·Ç·¨!\n";
		return(0);
	}
	return(1);
}

void output()
{
	int j = 0;
	for (; j <= i1 - flag; j++)
		cout << b[j]; //Êä³ö·ÖÎö´® 
	cout << "\t\t\t";
	cout << ch << "\t\t\t";//Êä³ö·ÖÎö×Ö·û
}

void output1()
{
	int j;
	for (j = i1 + 1 - flag; j<n1; j++)
		cout << a[j];
	cout << endl;
}

void input()
{
	int m, k, j, q;
	int i = 0;
	m = 0;
	k = 0;
	q = 0;
	i = n;
	d[n] = '=';
	d[n + 1] = '>';
	d[n + 2] = '#';
	n = n + 2;
	i = n;
	i = i - 2;
	while (d[i] != '>'&&i != 0)
		i = i - 1;
	i = i + 1;
	while (d[i] != e[0])
		i = i + 1;
	q = i;
	m = q;
	k = q;
	while (d[m] != '>')
		m = m - 1;
	m = m + 1;
	while (m != q)
	{
		d[n] = d[m];
		m = m + 1;
		n = n + 1;
	}
	d[n] = '#';
	for (j = 3; e[j] != '#'; j++)
	{
		d[n] = e[j];
		n = n + 1;
	}
	k = k + 1;
	while (d[k] != '=')
	{
		d[n] = d[k];
		n = n + 1;
		k = k + 1;
	}
	d[n] = '#';
}