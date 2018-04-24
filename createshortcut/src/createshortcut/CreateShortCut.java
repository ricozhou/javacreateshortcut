package createshortcut;

import java.io.File;

import net.jimmc.jshortcut.JShellLink;

public class CreateShortCut {

	public static void main(String[] args) {
		boolean isSucc = createLnk("E:\\Java\\workspace\\swing\\", "ScreenShot1.0.exe",
				"E:\\Java\\workspace\\swing\\sshot\\ScreenShot1.0.exe");
		System.out.println(isSucc);
	}

	public static boolean createLnk(String savePath, String appName, String exePath) {
		try {
			File f = new File(exePath);
			File f2 = new File(savePath);
			if (!f.exists() || !f2.exists()) {
				return false;
			}
			JShellLink link = new JShellLink();
			// 存放路径
			link.setFolder(savePath);
			// 快捷方式名称
			link.setName(appName);
			// 指向的exe
			link.setPath(exePath);
			link.save();
			return true;
		} catch (Throwable e) {
			// 是更改后的jar应用，直接全部抛出
			e.printStackTrace();
		}
		return false;
	}
}
