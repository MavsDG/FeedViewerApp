An Android app that fetches character data from the Rick and Morty API and displays them in a scrollable list. Created as part of a coding assessment.

FEATURES:
- Kotlin + MVVM Architecture
- Retrofit2 + Gson for API requests
- Room Database for offline caching
- ViewModel + LiveData + ViewBinding
- RecyclerView to display character list
- Glide for efficient image loading
- Material Design UI

How to Run
1. Clone the repo:
   ```bash
   git clone https://github.com/your-username/FeedViewerApp.git
2. Open the project in Android Studio
3. Sync Gradle and run the app on a physical device or emulator

Tech Stack
Tool / Library	Description
Kotlin	Main programming language
MVVM	Architecture pattern
Retrofit2 + Gson	API networking and JSON parsing
Room	Offline local database
LiveData + ViewModel	Lifecycle-aware observable data holders
RecyclerView	Efficient list UI rendering
Glide	Image loading and caching
ViewBinding	Type-safe access to views
Material Components	UI styling and interaction

ARCHITECTURE DIAGRAM
   UI (Activity) 
         ↓
     ViewModel 
         ↓
    Repository 
    ↙        ↘
Room DB    Retrofit API


AUTHOR
John Maverick De Guzman
📧 jmdeguzman.mavs98@gmail.com
🔗 https://github.com/MavsDG


This project is intended for educational and assessment purposes only.
