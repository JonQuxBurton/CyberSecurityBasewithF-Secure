
# Future directions?

A version of this essay with the correct formatting and references can be found here: https://github.com/JonQuxBurton/CyberSecurityBasewithF-Secure/blob/master/Advanced-Topics/Part-II/Future-directions.md

Machine learning is currently a hot topic across a range of fields. In CyberSecurity there is a pattern of increasing amounts of data (such as log files) being generated which is beyond human ability to process. This has creating a problem of how to analyse all this information for evidence of intrusion. There is already a problem with a shortage of security experts so there is a clear driver for trying to apply machine learning and other AI techniques to try to improve this.

This leads to the question of whether human intervention can be eliminated entirely, or alternatively whether a human attacker could succeed against a system defended only by AI. I would suggest that at present, human intervention is required and a human attacker could still succeed against an AI.
 
Machine learning is good at tasks such as identifying spam emails which involve finding similarities between things, however the problem is different here because we are looking for an anomaly instead. The problem is even more difficult as the attack surface of a system is very large, the signals given off by an attack may not be strong, and the attacker will intelligently change and adapt their behavior. Also the growth in use of IT in companies creates a corresponding growth in network traffic and this gives an increasing space for attackers to hide in.

In the past hackers have shown extremely high levels of cunning and skill and there is no reason to believe they would not know about machine learning. They will no doubt develop techniques to evade detection and disguise their actions. This can already be seen with Intrusion Detection evasion techniques[1], such as Fragmentation, breaking actions down into small steps and then mimicking normal traffic patterns.

Another technique an attacker could try to use to confuse an AI is Adversarial Examples. For example it was possible to take a picture of a panda, add a specially created overlay, which to the human eye just looks like noise, and now an AI classifies the picture as a Gibbon with 99% confidence[2]. The reasons for the AI making this mistake are currently unknown.

An attacker may even be able to go further if the AI system is learning from the data it scanning. They might even be able to influence how it learns (this is known as poisoning the model). This is similar to the embarrassing example of the Tay bot made by Microsoft[3] which was an AI chatbot which began to post offensive tweets after trolls targeted it. This happened within 16 hours of the bot being launched.

Interestingly it would seem that AI can now also be used in the offensive. Researchers at the security company Endgame have developed AI which made small 
mutations to malware and then scanned them with VirusTotal and checked the response[4]. So it would seems that we may see an arms race between offensive and defensive AIs in the future. 

Another argument against using AI only systems is that this it is not being done in the real world by current state of the art systems. Rather the current approach is Attended Machine Learning. One example of this is F-Secure's Rapid Detection Service [5]  which works by placing sensors into the Customers systems then feeding this large amount of data to the AI system which classifies it and tries to identify anomalies. The results this produces are then passes on to actual human security experts to interpret and take action. MIT’s AI2 system has a similar way of working[6].

The next question is, is this the start of Skynet?
I don't think it is possible to know this and there is much debate about the topic of Artificial General Intelligence (AGI), such as 
"AlphaGo Zero and the Foom Debate" by Eliezer Yudkowsky[7] versus "What Evidence Is AlphaGo Zero Re AGI Complexity?" by Robin Hanson[8].

As an example there is Google's AlphaGo Zero which is a system which plays Go and learns by just playing against itself. It is certainly extremely impressive that AlphaGo Zero was able to beat the previous AlphaGo system which itself beat the best human player, so in effect surpassing centuries of human learning in only 3 days of training. However to create a true AGI it seems likely that it would take "unforeseeable and fundamentally unpredictable breakthroughs"[9]. Also the difficulty of creating an AGI has certainly been underestimated a number of times in the past, for example the Dartmouth Workshop in 1956 suggested they would do it with a 10 man project in a 2 months project[10]. 

The next question is can machines recognise the emotion just from text?
I think the answer to this is a partial yes. machine learning does not show deep understanding of text, but can get the gist of emotion through Sentiment analysis, a technique which is already in use.

An example of this is Watson from IBM [11]. This uses natural language processing of news stories, social media posts and the IBM X-Force research library which includes years of information on vulnerabilities. Another example is in investment where hedge funds are using systems which scan articles about a company and work out whether they are positive or negative and this feeds into the automated trading decision whether to buy or sell shares in that company[12].
 
 ---
 
 References
 
 [1] IDS Evasion Techniques - https://en.wikipedia.org/wiki/Intrusion_detection_system#Evasion_techniques
 
 [2] Attacking Machine Learning with Adversarial Examples - https://blog.openai.com/adversarial-example-research/
 
 [3] TayBot -  https://en.wikipedia.org/wiki/Tay_(bot)
 
 [4] Evading Evading Machine Learning Malware Detection - https://www.blackhat.com/docs/us-17/thursday/us-17-Anderson-Bot-Vs-Bot-Evading-Machine-Learning-Malware-Detection-wp.pdf
 
 [5] F-Secure - https://www.f-secure.com/en/web/business_global/rapid-detection-service
 
 [6] AI2 - http://news.mit.edu/2016/ai-system-predicts-85-percent-cyber-attacks-using-input-human-experts-0418
 
 [7] https://www.lesserwrong.com/posts/shnSyzv4Jq3bhMNw5/alphago-zero-and-the-foom-debate
 
 [8] https://www.lesserwrong.com/posts/D3NspiH2nhKA6B2PE/what-evidence-is-alphago-zero-re-agi-complexity
 
 [9] Paul Allen: The Singularity Isn't Near - https://www.technologyreview.com/s/425733/paul-allen-the-singularity-isnt-near/
 
 [10] Dartmouth Workshop - https://en.wikipedia.org/wiki/Dartmouth_workshop
 
 [11] Watson - https://www.ibm.com/security/cognitive
 
 [12] How Quant Traders Use Sentiment To Get An Edge On The Market - 
https://www.forbes.com/sites/kumesharoomoogan/2015/08/06/how-quant-traders-use-sentiment-to-get-an-edge-on-the-market/#56a3eb2d4b5d
