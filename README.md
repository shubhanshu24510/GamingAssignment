### Cat Image App - Fetch and Display Cat Images

This is an Android app built in Kotlin that fetches cat images from an API and displays them in a list using a `RecyclerView`. When a user clicks on an image, a new screen opens showing the image in a larger size along with the image's width and height.

### Features
- Displays a list of cat images fetched from an external API using **Retrofit**.
- Displays the cat image in full screen with its dimensions when clicked.
- Uses **MVVM** architecture for clean code and separation of concerns.
- Supports placeholder images while loading the actual image.

### Project Structure
data/
   ├── model/
   │   └── Cat.kt
   ├── api/
   │   ├── ApiService.kt
   │   └── RetrofitInstance.kt
repository/
   └── CatRepository.kt
ui/
   ├── adapter/
   │   └── CatAdapter.kt
   ├── main/
   │   ├── MainActivity.kt
   │   ├── MainViewModel.kt
   │   └── MainViewModelFactory.kt
   ├── detail/
   │   └── DetailActivity.kt
utils/
   └── Resource.kt
res/
   └── layout/
       ├── activity_main.xml
       ├── item_cat.xml
       └── activity_detail.xml

### How to Use
1. Main Screen (Cat List):
** The app displays a list of 10 cat images fetched from the cat API.
**Click on any image to view it in full size along with its width and height.

2. Detail Screen:
** When you click on an image in the list, it will open in full-screen mode along with its width and height displayed below the image.

### Video Demonstration
https://github.com/user-attachments/assets/5112b4a9-c406-4715-8453-b50b1b98609c
