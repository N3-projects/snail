package n3.java.classload;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hzyemao
 * @version 1.0 , 2017/3/30
 */
public class ClassUtil
{
	private static final String CLASS_FILE_SUFFIX = ".class";

	public static <E> List<Class<? extends E>> loadSubClassesInResourcePath(Class<E> superClass, String resourcePath)
			throws Exception
	{
		URL resourceUrl = getDefaultClassLoader().getResource(resourcePath);

		return loadSubClassesInResourcePath(superClass, resourcePath, new File(resourceUrl.getFile()));
	}

	@SuppressWarnings("unchecked")
	private static <E> List<Class<? extends E>> loadSubClassesInResourcePath(Class<E> superClass, String resourcePath,
			File filePath) throws Exception
	{
		List<Class<? extends E>> classList = new ArrayList<>();
		if (filePath == null || !filePath.exists())
		{
			return classList;
		}
		if (filePath.isDirectory())
		{
			File[] files = filePath.listFiles();
			if (ArrayUtils.isEmpty(files))
			{
				return classList;
			}
			for (File subFile : files)
			{
				classList.addAll(loadSubClassesInResourcePath(superClass, resourcePath+"/"+subFile.getName(), subFile));
			}
		}
		else
		{
			String fileName = filePath.getName();
			if (StringUtils.endsWith(fileName, CLASS_FILE_SUFFIX))
			{
				String className = resourcePath.replace("/", ".") + StringUtils.substring(fileName, 0, -6);
				Class<?> clz = Class.forName(className);
				if (superClass.isAssignableFrom(clz))
				{
					classList.add((Class<? extends E>) clz);
				}
			}
		}
		return classList;
	}

	public static ClassLoader getDefaultClassLoader()
	{
		ClassLoader loader = null;
		try
		{
			loader = Thread.currentThread().getContextClassLoader();
		}
		catch (Exception e)
		{

		}
		return loader != null ? loader : ClassUtil.class.getClassLoader();
	}

	public static String convertClassPackage2ResourcePath(Class clz)
	{
		if (clz == null)
		{
			return null;
		}
		String className = clz.getName();
		int packageEndIndex = className.lastIndexOf('.');
		if (packageEndIndex == -1)
		{
			return StringUtils.EMPTY;
		}
		String packageName = className.substring(0, packageEndIndex);
		return packageName.replace('.', '/');
	}
}
