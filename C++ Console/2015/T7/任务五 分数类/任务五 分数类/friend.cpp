#include"fenshu.h"
istream&operator>>(istream& input,fenshu& fs)
{
	input>>fs.fenz>>fs.fenm;
	return input;
}
ostream&operator<<(ostream& output,fenshu& fs)
{
	output<<fs.fenz<<"/"<<fs.fenm;
	return output;
}
fenshu operator+(fenshu a,fenshu b)
{
	fenshu c;
	int t,tt;
	if(a.fenm!=b.fenm)
	{
		c.fenm=a.fenm*b.fenm;
		c.fenz=a.fenz*b.fenm+b.fenz*a.fenm;
	}
	else
	{
		c.fenm=a.fenm;
		c.fenz=a.fenz+b.fenz;
	}
	int i;
	if(c.fenz>c.fenm)
	{
		tt=c.fenz;	
		t=c.fenm;
	}
	else
	{
		tt=c.fenm;
		t=c.fenz;
	}
	for(i=t;i>0;i--)
	{
		if(t%i==0&&tt%i==0)
		{
			c.fenm=c.fenm/i;
			c.fenz=c.fenz/i;
		}

	}
	return c;
}
fenshu operator-(fenshu a,fenshu b)
{
	fenshu c;
	int t,tt;
	if(a.fenm!=b.fenm)
	{
		c.fenm=a.fenm*b.fenm;
		c.fenz=a.fenz*b.fenm-b.fenz*a.fenm;
	}
	else
	{
		c.fenm=a.fenm;
		c.fenz=a.fenz-b.fenz;
	}
	int i;
	if(c.fenz>c.fenm)
	{
		tt=c.fenz;	
		t=c.fenm;
	}
	else
	{
		tt=c.fenm;
		t=c.fenz;
	}
	for(i=t;i>0;i--)
	{
		if(t%i==0&&tt%i==0)
		{
			c.fenm=c.fenm/i;
			c.fenz=c.fenz/i;
		}

	}
	return c;
}
fenshu operator*(fenshu a,fenshu b)
{
	fenshu c;
	int t,tt;

	c.fenm=a.fenm*b.fenm;
	c.fenz=a.fenz*b.fenz;

	int i;
	if(c.fenz>c.fenm)
	{
		tt=c.fenz;	
		t=c.fenm;
	}
	else
	{
		tt=c.fenm;
		t=c.fenz;
	}
	for(i=t;i>0;i--)
	{
		if(t%i==0&&tt%i==0)
		{
			c.fenm=c.fenm/i;
			c.fenz=c.fenz/i;
		}

	}
	return c;
}