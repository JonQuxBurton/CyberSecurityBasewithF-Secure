# Gamifying threat-finding

A version of this essay with the correct formatting and references can be found here: https://github.com/JonQuxBurton/CyberSecurityBasewithF-Secure/Advanced-Topics/Part-I/Gamifying-threat-finding.md

I think that gamified threat modeling can be a useful technique to employ. Looking at an example of gamified threat modeling, the Elevation of Privilege card (EoP) game made by Microsoft, works as follows. A set of cards is divided into security related "suits", with each card having a description of a threat. The first player plays a card from one of the suits and then tries to apply this threat to one of the elements of the systems Data Flow Diagram (DFD). The other players then take turns to each play a card from the same suit and the player with the highest card wins the round. Players score a point for each threat identified and an extra point for winning the round, giving it a mildly competitive edge. Another game Cornucopia by OWASP consists of the same game mechanics but with the suits being more relevant to web applications, such as Session management.

There are a number of benefits to the gamified approach, as follows.

The mechanics of these games are basically the same as applying a checklist. Each card would be a threat from the checklist and the suits of EoP are the categories of STRIDE. To do this without playing a game could be a brainstorming meeting where the developers apply the STRIDE-per-element approach to the DFD. By gamifiying the process, the discussion will naturally be more spread out between the developers, as each takes their turn. Without a game it is more likely that the discussion could become dominated by the most experienced, senior or extroverted people [1]. The game format helps to get people talking. It can also reduce the problem of the "looking out the window" effect where the other people are less engaged.

Although it is gamified, it is not a true game, rather it is a "Serious game". Which is a game with an education purpose and the focus is not on winning, so players don't hide their cards from each other and players can help each other [2]. As such the game is also likely to be good for training. This is what Microsoft now use it for [3]. If a player cannot apply their threat then others are free to help out and thus by playing the game they are also sharing knowledge. This will be especially helpful for junior/new developers and companies with less security experience.

There are some limitations to the gamified threat modeling though.
As the games mechanics are really just a checklist, they will be constrained by this, and a team of experts that know the checklist well would be able to go through it and apply it more quickly. Another problem is with the suits. As these are groupings of threats they must be somewhat abstract. This makes it more of a difficulty to map these abstract ideas to a genuine threat to the system, especially for developers with less security knowledge. An alternative approach here would be an Attack List which has attacks which are not not abstract as they each describe a specific attack.

In conclusion, I think that one can find threats with a game, in a similar way to a checklist style approach, but with a greater chance of engagement from all the developers on the team. They are also useful for training and developers with less security knowledge.

---

References

[1] - Elevation of Privilege: Drawing Developers into Threat Modeling by Adam Shostack
https://www.microsoft.com/en-us/SDL/adopt/eop.aspx
"A game forces participation..."

[2] - Elevation of Privilege: Drawing Developers into Threat Modeling by Adam Shostack
https://www.microsoft.com/en-us/SDL/adopt/eop.aspx
"Serious Games"
"The use of play and games to teach skills or lessons has a long, complex history."

[3] - Elevation of Privilege: Drawing Developers into Threat Modeling by Adam Shostack
https://www.microsoft.com/en-us/SDL/adopt/eop.aspx
"Inside of Microsoft, Elevation of Privilege has been more popular as a training tool than as a threat modeling tool..."
