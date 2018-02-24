# Bigger attack surface?

A version of this essay with the correct formatting and references can be found here: https://github.com/JonQuxBurton/CyberSecurityBasewithF-Secure/blob/master/Advanced-Topics/Part-IV/Bigger-attack-surface.md

The first question is: Does 5G increase the attack surface? 

Yes the attack surface is increased in a number of ways. 
5G networks will require lots more base stations known as small cells in order to provide the increased bandwidth and increased density of users. The need for all the small cells means that some will have to be in more vulnerable locations and so there is more risk of physical tampering. It has not been decided yet whether the data will be decrypted inside these base stations but if it is they could be a tempting target for hackers.

Another increase in attack surface will be due to an increase in the diversity of connected devices. Some may be highly mobile (such as cars) and have a broad range of operating systems, battery power, CPUs and memory.
There will also be an increase in the communication technologies. If a device is unable to connect to the 5G network it could downgrade to 4G or 3G. So we will inherit security issues from older networks too.

Another part of 5G is Device-to-Device (D2D) communication which enables devices to communication directly without sending the data through the network[1]. This also increases the attack surface, especially if the devices communicate using open access where the data is relayed through other devices.

The next question is: Will user equipment with a fast connection be a tempting target? 

Yes they will be targets for a number of reasons.
Since many devices will be always turned on, always connected to the Internet with fast connections, they will make ideal targets for botnets[2].

Another use would be to target enterprises. An employees smart phone which is on the companies network could be used to deliver a malicious payload, which is sent to it through a different channel such as D2D (see above).

The next question is: Is 5G vulnerable to DDoS?

Yes 5G networks are vulnerable to DDoS attacks. As they are data networks and use an IP based architecture they can be flooded in a similar way as that which occurs on the Internet today[3]. The use of small cells may have benefits and drawbacks. As they are small, it wold be easier for an attacker to overwhelm a single one, but as there will be many of them, there will be no single point of failure. Perhaps this will make them a more robust, decentralized network (see Bitcoin network).

The next question is: Is Backwards compatibility a problem?

Backwards compatibility with 4G should not be a problem as 5G will use a different part of the spectrum. While 4G uses the spectrum below 6GHz, 5G will use above 6GHz[4], or even the extremely high frequency bands beyond 30GHz known as millimetre wavelengths which would allow much higher data transfer rates.

The next question is: Is securing 5G enough or do we need better end-to-end solutions?

End-to-end solutions will probably be useful. As there will be many small cells, there will be many locations for an attacker to target. Once one is compromised the attacker can then eavesdrop on all the data sent through this cell, if it is not encrypted. End-to-end encryption would help to mitigate this.

---

References

[1] Device-to-Device Communication in 5G Cellular Networks: Challenges, Solutions, and Future Directions -
http://sce.carleton.ca/faculty/yanikomeroglu/Pub/ComMag-May2014-mntmuhy.pdf

[2] 9.3.1.2 5G Mobile Botnets - http://openaccess.city.ac.uk/13047/1/Chapter_Security_for_5G_Communications_final.pdf

[3] 9.3.3 - http://openaccess.city.ac.uk/13047/1/Chapter_Security_for_5G_Communications_final.pdf

[4] ericsson White paper - https://www.ericsson.com/assets/local/news/2015/2/wp-5g.pdf
