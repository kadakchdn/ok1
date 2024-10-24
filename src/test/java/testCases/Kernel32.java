package testCases;

import com.sun.jna.Native;


import com.sun.jna.platform.win32.WinNT.HANDLE;

public interface Kernel32 extends com.sun.jna.Library
{
	 Kernel32 INSTANCE = Native.load("Kernel32", Kernel32.class);

	    // OpenProcess method
	    HANDLE OpenProcess(int dwDesiredAccess, boolean bInheritHandle, int dwProcessId);

	    // CloseHandle method
	    boolean CloseHandle(HANDLE hObject);

	    // Constants for process access
	    int PROCESS_QUERY_INFORMATION = 0x0400;
	    int PROCESS_VM_READ = 0x0010;

}
