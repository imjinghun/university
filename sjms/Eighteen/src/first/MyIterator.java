package first;

interface MyIterator
{
	void first();
	void last();
	void next();
	void previous();
	boolean isLast();
	Student currentItem();
	boolean isFirst();
}
