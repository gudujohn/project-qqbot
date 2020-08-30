#include <file.au3>

Dim $logFile="sendMessage.log"
_FileWriteLog($logFile, "==================", -1)
if 2 > $CmdLine[0] Then
   _FileWriteLog($logFile, $CmdLine[0], -1)
   Exit
EndIf
Dim $name=$CmdLine[1]
Dim $msg=$CmdLine[2]
Dim $prefix=$name & ": " & $msg
_FileWriteLog($logFile, $prefix & " start", -1)
Sleep(200)
If WinActivate($name,"") Then
   _FileWriteLog($logFile, $prefix & " after WinActivate ok", -1)
Else
   _FileWriteLog($logFile, $prefix & " after WinActivate error, will retry at least 5 times", -1)
   Local $WinActivateResult = 0
   Local $i = 1
   While $i <= 5
	   Sleep(200)
	   WinActivate("QQ","")
	   Sleep(1000)
       Send($name)
	   Sleep(2000)
	   Send("{ENTER}")
	   Sleep(200)
	   $WinActivateResult = WinActivate($name,"")
	   _FileWriteLog($logFile, $prefix & " after WinActivate error, after retry " & $i & " times, result = " & $WinActivateResult, -1)
	   If $WinActivateResult > 0 Then ExitLoop
	   $i = $i + 1
   WEnd
EndIf
Sleep(200)
If WinSetState ($name, "", @SW_ENABLE) Then
   _FileWriteLog($logFile, $prefix & " after WinSetState(enable) ok", -1)
Else
   _FileWriteLog($logFile, $prefix & " after WinSetState(enable) error", -1)
EndIf
Sleep(200)
If WinSetOnTop ($name, "", 1) Then
   _FileWriteLog($logFile, $prefix & " after WinSetOnTop ok", -1)
Else
   _FileWriteLog($logFile, $prefix & " after WinSetOnTop error", -1)
EndIf
Sleep(1000)
If ClipPut($msg) = 1 Then
   _FileWriteLog($logFile, $prefix & " after ClipPut ok", -1)
Else
   _FileWriteLog($logFile, $prefix & " after ClipPut ok", -1)
EndIf
Sleep(200)
Send("^v")
Sleep(500)
Send("^{ENTER}")
_FileWriteLog($logFile, $prefix & " after Send", -1)
_FileWriteLog($logFile, $prefix & " end", -1)