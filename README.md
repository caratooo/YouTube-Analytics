# YouTube-Analytics

This project is for CSC207H1
Contributors: Jonathan Chen, Alex Tran, Zoey Xie, Cynthia Zhou

Project domain: Statistics/Data Analytics
API: Youtube Data V3

Project Specifications:
This project is inspired by the Youtube creator dashboard. This software's goals are to be able to lookup information about channels and videos, compare different videos through quantifiable metrics, look up trending videos through either Youtube's official trending algorithm or in specific categories, and should have the ability to retrieve the 5 most recent queries each user viewed (with the exception for live trending results). 
The program will be visually presented by the Java swing library, with interactive buttons, menus, and typed searched bars. The visuals will be minimalistic to avoid confusion on how to navigate the program; there will also be a help button that users can click on each view in order to get more detailed assistance. 
This program will be helpful for Youtube content creators or general users who want to explore meaningful insights about Youtube. 
Information about the users will be stored in .txt files, and there will be an account system that identifies users through their unique usernames and their respective passwords. There will also be .txt files that stores each user's past queries. 

Use Cases:
  Video Lookup:
    Returns meaningful insights about the video in the form of quantifiable metrics such as like counts, view counts, like-to-view ratio, and etc.
  Channel Lookup:
    Returns meaningful insights about the channnel in the form of quantifiable metrics such as total video posted, total views, subscriber count, and etc.
  Video Comparison:
    Shows a side-by-side comparison of each of the metrics that were returned in the Video Lookup use case; quantifies the difference in each metric through both net difference and percentage difference.
  Trending Lookup:
    Returns the top performing videos by default; filters by video category if specified by the users in a dropdown menu of buttons. 
  History Lookup:
    Returns the 5 most recent views that the user looked up outside of trending lookups.
