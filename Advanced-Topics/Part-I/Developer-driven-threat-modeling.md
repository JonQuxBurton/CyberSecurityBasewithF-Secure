# Developer-driven threat modeling

A version of this essay with the correct formatting and references can be found here: https://github.com/JonQuxBurton/CyberSecurityBasewithF-Secure/blob/master/Advanced-Topics/Part-I/Developer-driven-threat-modeling.md

We have looked at the use of STRIDE for threat modeling, but an alternative approach would be to use an Attack List. 

Lets examine the advantages which Attack lists have over STRIDE.
As the threats in an Attack List describe actual attacks, the approach seems less abstract than STRIDE. This also makes it feel more natural and intuitive, for example when building a web page it's easy to think of (and try) entering a SQL injection attack string into a form. Also most developers will have tried this at some point,
In this way it takes less security knowledge to apply than STRIDE, which requires the developer to convert the category into a tangible attack.

Another advantage is that an attack list can be tailored to suit the specifics of the company. It is obvious that if a company suffered a problem from a vulnerability then it should be on the Attack List and checked consistently from then on. You would also imagine that threats which don't seem to be a problem could be pruned from the list. Over time then the list will become a good fit.

The Attack list should ideally be maintained by a security team (or the most security aware developers) so they can apply their expertise to it. They may need to present it to other developers and share it, so spreading the knowledge. Also just using the list will help increase security knowledge.

Now lets look at the disadvantages of Attack Lists.

It could be argued that they are too specific, and that actually being abstract, like STRIDE, is better. Having the attacks specific in this way, can make it harder to think of different threats which are not on the attack list[1].

The Attack List takes effort to create and to maintain. As above it will need to be shared and explained with other developers which also takes time. The famous OWASP
top ten threats list recently been updated in 2017[2] for the first time since 2013. New threats have been added, and some removed, so we don't need to check for these anymore, right?

In the article EMC created an Attack List with 35 threats on it, but how do we know this is enough? AT the same time is it too many? That's a lot to scan through, and also too many to hold in memory, which would be more like seven plus or minus 2[3].

I searched, but did not find many references to the Attack List approach in the literature. Perhaps this approach is not being widely used, though this is only weak evidence, as it may be that people are just not publishing much about it for some other reason.


Now lets consider whether using an Attack List is realistic.
It is easy to imagine the list getting big without conscious effort to constrain it. For example, the well known list of CAPEC has 508. Though EMC kept their list to 35 and this seems like a realistic size.

During threat modeling a common approach is to draw a Data FLow Diagram (DFD) of the system and attach the threats to the elements on it (such as in the STRIDE-per-element approach). Though this can result in a large number of potential threats. This problem could become unmanageable if we were also using an attack list with 35 threats such as EMC, trying to apply it to every element of the the DFD. The alternative approach they tried, was to use the interactions between the elements instead, which reduces them down to 3. This approach would be essential with an Attack List.

Now lets explore whether Attack List are better than checklists.
They seem quite similar to me, just a matter of granularity.
An Attack List has specific threats, but then you can try to classify these threats into groups and then eventually will end up with something like STRIDE.
For example, the CAPEC list has 508 threats, which are then been grouped into 16 categories, such as "Inject Unexpected Items" and "Social Engineering".

When doing this though, some threats will always be difficult to fit into the classifications (a similar problem to classifying the duck billed platypus which lays eggs but is a mammal and also has a venomous claw). 

So I think that a good approach would be to have a blend of the abstract and specifics. So you would have a library resembling:

1. General abstract categories (such as STRIDE)

2. Specific Attacks (giving a concrete example from each category)

3. Specific Attacks which don't easily fit into categories.

So in conclusion I would say I am for using Attack Lists as they are more tangible than STRIDE, and natural and intuitive to apply. The best Attack List would be a blend of abstract categories and specific attacks.


If we decided to use an Attack List, one idea might be to use a site such as HackeOne to create the list.
This site publishes bug reports to a page called 'Hacktivity'[4] and one could read through these to create an Attack List.
One benefit of doing this is that you would get a good idea of trends. One such as having unsecured S3 buckets are quite common nowadays, even at HackerOne themselves [5].
Unfortunately to do this would be very time consuming as there are very many reports, a quick scan show that there were 40 reports produced today. Another problem is that many of the reports are not disclosed, so maybe the most dangerous ones aren't visible. Also many of these reports won't be relevant to other companies.
An alternative shortcut might be to just use the book - "Web Hacking 101" by Peter Yaworski[6] which list a selection of reports.

---

References

[1] wheres-risk-threat-library - https://blogs.metricstream.com/wheres-risk-threat-library/

[2] OWASP Top Ten Project - https://www.owasp.org/index.php/Category:OWASP_Top_Ten_Project

[3] The Magical Number Seven, Plus or Minus Two - https://en.wikipedia.org/wiki/The_Magical_Number_Seven,_Plus_or_Minus_Two

[4] HackerOne - Hacktivity -https://hackerone.com/hacktivity?sort_type=latest_disclosable_activity_at&filter=type%3Aall&page=1&range=forever

[5] See HackerOne S3 Buckets Open - https://hackerone.com/reports/128088

[6] Web Hacking 101 How to Make Money Hacking Ethically by Peter Yaworski - https://leanpub.com/web-hacking-101
