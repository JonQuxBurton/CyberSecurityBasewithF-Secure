#Anything can be hacked?

A version of this essay with the correct formatting and references can be found here: https://github.com/JonQuxBurton/CyberSecurityBasewithF-Secure/blob/master/Advanced-Topics/Part-V/Anything-can-be-hacked.md

The security problems faced by IoT devices has been in the news a number of times over recent years, so this leads to the question - why has the security IoT devices become a problem?

One part of the problem is the lack of public awareness of the security of IoT devices. When a consumers purchases a device they may have in mind the model of a one-time purchase that then just works, rather than the model of a device which requires regular updates, patches and maintenance. Another problem is that the consumer may not have the technical knowledge to differentiate between devices on their security. Also there are no certification schemes to help them. Interestingly though an ISOC report on security in routing suggests that some consumers would actually pay a premium price for more secure devices. 

The visibility of the security problem is another reason. Consumers may not actually be affected all that much if their device is taken over by a botnet. For example in the case of the Mirai botnet, the main symptoms were occasional slowness and increased bandwidth. Even if the owner spots this and reboots the device it would be reinfected within minutes (if the password is not changed) [1]. Also they may not even realise that their device can be compromised at all, as it is not necessarily obvious to a non-technical person that a simple light bulb could contribute to a DDoS attack. Thus they may also not even be aware that their devices can be patched and updated.

Another part of the problem is the manufacturers of devices. Mistakes can be made by the developers not following security design principles, assuming that devices will be inaccessible from the Internet. Or perhaps the user interface has design flaws making it difficult to secure the device, creating a good user interface would incur some cost. Also manufacturers may not really understand how to make their devices secure, as it has never been part of their product expertise previously.

There is a general misalignment with market incentives of IoT security[2]. Manufacturers incentives are to produce devices at minimum cost and fastest time to market. Consumers incentives are around price and features. Whilst the costs of DDoS attacks are borne by other businesses. So it is a system wide problem, which needs the parties to all play their part to solve.

---

References

[1] Mirai Malware - https://en.wikipedia.org/wiki/Mirai_(malware)

[2] 5. Market incentives are misaligned - A Report to the President on Enhancing the Resilience of the Internet and Communications Ecosystem Against Botnets and Other Automated, Distributed Threats - https://www.ntia.doc.gov/files/ntia/publications/eo_13800_botnet_report_for_public_comment.pdf
