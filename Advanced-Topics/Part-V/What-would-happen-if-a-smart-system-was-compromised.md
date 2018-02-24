# What would happen if a “smart” system was compromised?

A version of this essay with the correct formatting and references can be found here: https://github.com/JonQuxBurton/CyberSecurityBasewithF-Secure/blob/master/Advanced-Topics/Part-V/What-would-happen-if-a-smart-system-was-compromised.md

One IoT device that is now available is the Smart TV, and these can create some new security issues. A Smart TV would probably count as a high-end IoT device, and they are not as constrained as low-end devices. I think there could be a classification debate as they are quite close to being real computers, though they do also have their own attack vector which will be described later.

The biggest issue with Smart TVs would concern privacy. In fact you could say that they are the perfect target for surveillance. The in-built camera can video, or take pictures, and the microphone can listen to private conversations. This could be done by a hacker getting control of the TV or the maker of the TV such as Samsung's voice activation feature[1]. This is getting close to the Telescreens from George Orwell's 1984[2].

But at least you can stop this by turning off the TV. Except researchers have managed to put a hook into the power off code which prevents the TV switching off, but does make the TV appear to be off, even including the stand-by LED. So it can continue eavesdropping 24 hours a day[3].

A hacker who succeeds in hacking a smart TV will gain root privileges with full access, as they are single user systems. They can then put it to use in many ways, such as:

adding the TV to a botnet for a DDoS attack.

using the web browser to click on adverts for click fraud.

falsifying likes and posting comments on social media.

installing a key logger.

using it a as jump board to attack other IoT devices on the network.

The owner of the TV is probably unaware that any of this is occurring. There is also the risk that they will simply brick the TV, so that it has to be repaired by the manufacturer.

Smart TVs even have their own attack vector. Researchers have managed to hack them through the television signal itself[4]. They used their own antenna to broadcast a TV transmission with a malicious payload which would infect a receiving Smart TV. Though this attack would be an expensive and sophisticated, it might be viable in urban areas where the original TV signal can be overpowered and there is a higher density of Smart TVs nearby.

---

References

[1] Samsung Smart TV Policy -  https://www.independent.co.uk/life-style/gadgets-and-tech/news/samsungs-new-smart-tv-policy-allows-company-to-listen-in-on-users-10033012.html

[2] 1984 by George Orwell - https://en.wikipedia.org/wiki/Telescreen

[3] https://media.blackhat.com/us-13/US-13-Lee-Hacking-Surveilling-and-Deceiving-Victims-on-Smart-TV-Slides.pdf

[4] From the Aether to the Ethernet – Attacking the Internet using Broadcast Digital Television Yossef Oren, Angelos D. Keromytis - http://iss.oy.ne.ro/Aether.pdf
