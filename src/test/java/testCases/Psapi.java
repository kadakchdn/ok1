package testCases;

import com.sun.jna.Native;


import com.sun.jna.platform.win32.WinDef.DWORD;

import com.sun.jna.platform.win32.WinNT.HANDLE;

public interface Psapi<WString> extends com.sun.jna.Library
{
    Psapi INSTANCE = Native.load("Psapi", Psapi.class);

    // GetProcessImageFileName method
 

	<WString> DWORD GetProcessImageFileName(HANDLE hProcess, WString lpImageFileName, DWORD nSize);
}
