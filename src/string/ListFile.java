package string;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class ListFile
{

	public static void main(String[] args)
	{

		try
		{
			foreachFileDir("D:/Downloads");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	// 遍历文件下所有文件路径
	// 需要借助队列（FIFO），进行缓存顺序取出
	private static void foreachFileDir(String path) throws IOException
	{
		LinkedList<File> mDeque = new LinkedList<>();
		File file = new File(path);
		if (file.exists())
		{
			mDeque.offer(file);
			while (true)
			{
				file = mDeque.poll();
				if (file == null)
					break;
				File[] files = file.listFiles();
				for (File file2 : files)
				{
					if (file2.isDirectory())
					{
						mDeque.offer(file2);
						continue;
					}
					//
					if (file2.isFile())
					{
						System.out.print("文件路径：" + file2.getCanonicalPath());
					}
				}
			}
		}
	}

}
