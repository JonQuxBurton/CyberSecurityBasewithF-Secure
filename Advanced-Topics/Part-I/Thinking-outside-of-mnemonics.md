Thinking outside of mnemonics

A version of this essay with the correct formatting and references can be found here: https://github.com/JonQuxBurton/CyberSecurityBasewithF-Secure/blob/master/Advanced-Topics/Part-I/Thinking-outside-of-mnemonics.md

To get ideas for threat modeling a system, I would suggest that a team take a structured approach consisting of the following steps.
Step 1. Hold a brainstorming session.
Step 2. Produce a Data Flow Diagram (DFD).
Step 3. Apply the STRIDE-per-element technique to the DFD.
Step 4. Analyze all the identified threats and devise mitigations.

Now to examine these steps in more detail.

Step 1. Hold a brainstorming session.

This involves getting everyone on the development team together for the Big Threat Modeling Meeting. At  Microsoft every single developer is consulted (as they wrote the code and have the most knowledge of how it works) and also the program manager.[1]

Important questions to ask should include:
What are the assets which need to be protected?
Who would try to perform an attack?
What would their motivation be?

Another aspect to discuss would be around the code of the system,such as:
Reading through the code and the unit tests.
Reading the code review comments.
Reading the documentation of both the code and the design. For example if there are claims in the documentation like that HTTPS is used - has this been correctly implemented?[2]

Libraries of vulnerabilities could be consulted by the team, such as OWASP, Common Weakness and Enumeration(CWE), and Common Attack Pattern Enumeration and Classification (CAPEC) though here the team may end up being overwhelmed by the volume of information.

It is also worth considering non technical threats such as Social Engineering, Bribery, Theft. Another technique which hackers use is Open Source Intelligence (OSINT) so also consider this such as any Github accounts for the company and developers (which could be scanned with Gitrob[3]).

Step 2. Produce a Data Flow Diagram (DFD).

The output of the previous meeting should be a Data Flow Diagram showing the flow of data through the system, the main elements of the system, External Entities, Processes, Data Stores and Data Flows, and also the trust boundaries. 
 
Step 3. Apply the STRIDE-per-element technique to the DFD.

In this approach, the STIDE checklist is applied to each element of the DFD, which has all the threats identified attached to it.
Some rules of thumb [4] can be applied here to help generate ideas such as:
If data hasn't crossed a trust boundary it's low risk.
If the code runs with elevated privileges it is a higher risk.
If the code can run scripts or other code it is much higher risk.

This produce a fairly long list of the potential threats to the system. In the example here [5] a relatively small application had 33 different ways in which it could be attacked.

The DFD may have also made some threats very apparent, for example if XML is being used across a trust boundary then there are a number of well known threats (such as a Denial of Service the Billion laughs attack[6])

Step 4. Analyze all the identified threats and devise mitigations.
Some of the threats identified may be irrelevant or duplicated and so can be ignored, but it is still good that they have been recorded and evaluated. For the rest the team can now move on from threat modeling and onto mitigating them. 

The above process and it's finding should be documented for future use, as the threats faced by a system generally stay static. So this document itself would be a valuable source of threat ideas in the future.



References
[1] - Threat Modeling, once again https://blogs.msdn.microsoft.com/larryosterman/2007/08/30/threat-modeling-once-again/
[2] - Øredev 2017 - Maaret Pyhäjärvi - An Exploratory Tester’s lessons on Security Threat Modeling https://vimeo.com/242236526
[3] - Gitrob http://michenriksen.com/blog/gitrob-putting-the-open-source-in-osint/
[4] - Rules of thumb - https://blogs.msdn.microsoft.com/larryosterman/2007/08/30/threat-modeling-once-again/] 

[5] - PlaySound API - [From https://blogs.msdn.microsoft.com/larryosterman/2007/08/30/threat-modeling-once-again/]
[6] - Billion laughs attack https://en.wikipedia.org/wiki/Billion_laughs_attack 
and "A Hybrid Approach to Threat Modelling" - Sriram Krishnan https://blogs.sans.org/appsecstreetfighter/files/2017/03/A-Hybrid-Approach-to-Threat-Modelling.pdf
