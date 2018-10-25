package stack;

/**
 * 使用前后栈实现浏览器的前进后退。
 * 
 * @author 王贤宏
 */
public class SampleBrowser
{
	public static void main(String[] args)
	{
		SampleBrowser browser = new SampleBrowser();
		browser.open("http://www.baidu.com");
		browser.open("http://news.baidu.com/");
		browser.open("http://news.baidu.com/ent");
		browser.goBack();
		browser.goBack();
		browser.goForward();
		browser.open("http://www.qq.com");
		browser.goForward();
		browser.goBack();
		browser.goForward();
		browser.goBack();
		browser.goBack();
		browser.goBack();
		browser.goBack();
		browser.checkCurrentPage();
	}

	private String currentPage;
	private LinkedListBasedStack backStack;
	private LinkedListBasedStack forwardStack;

	public SampleBrowser()
	{
		this.backStack = new LinkedListBasedStack();
		this.forwardStack = new LinkedListBasedStack();
	}

	public boolean canGoBack()
	{
		return this.backStack.getSize() > 0;
	}

	public boolean canGoForward()
	{
		return this.forwardStack.getSize() > 0;
	}

	public void open(String url)
	{
		if (this.currentPage != null)
		{
			this.backStack.push(this.currentPage);
			this.forwardStack.clear();
		}
		showUrl(url, "Open");
	}

	public String goBack()
	{
		if (this.canGoBack())
		{
			this.forwardStack.push(this.currentPage);
			String backUrl = this.backStack.pop();
			showUrl(backUrl, "Back");
			return backUrl;
		}

		System.out.println("* Cannot go back, no pages behind.");
		return null;
	}

	public String goForward()
	{
		if (this.canGoForward())
		{
			this.backStack.push(this.currentPage);
			String forwardUrl = this.forwardStack.pop();
			showUrl(forwardUrl, "Foward");
			return forwardUrl;
		}

		System.out.println("** Cannot go forward, no pages ahead.");
		return null;
	}

	public void showUrl(String url, String prefix)
	{
		this.currentPage = url;
		System.out.println(prefix + " page == " + url);
	}

	public void checkCurrentPage()
	{
		System.out.println("Current page is: " + this.currentPage);
	}

	// 链表式栈
	public static class LinkedListBasedStack
	{
		private int size;
		private Node topNode;

		public static Node createNode(String data, Node next)
		{
			return new Node(data, next);
		}

		public void clear()
		{
			this.size = 0;
			this.topNode = null;
		}

		public int getSize()
		{
			return this.size;
		}

		public String getTopData()
		{
			if (topNode == null)
				return null;

			return this.topNode.data;
		}

		public void push(String data)
		{
			Node node = createNode(data, this.topNode);
			topNode = node;
			size++;
		}

		public String pop()
		{
			Node popNode = topNode;
			if (popNode == null)
			{
				System.out.println("Stack is empty.");
				return null;
			}
			topNode = popNode.next;
			if (size > 0)
				size--;
			return popNode.data;
		}

		// 结点类
		public static class Node
		{
			private String data;
			private Node next;

			public Node(String data)
			{
				this(data, null);
			}

			public Node(String data, Node next)
			{
				this.data = data;
				this.next = next;
			}

			public void setData(String data)
			{
				this.data = data;
			}

			public String getData()
			{
				return this.data;
			}

			public void setNext(Node next)
			{
				this.next = next;
			}

			public Node getNext()
			{
				return this.next;
			}
		}
	}

}
