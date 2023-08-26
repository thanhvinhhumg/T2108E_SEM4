
import 'package:demo_app/pages/home_page.dart';
import 'package:demo_app/pages/session_34.dart';
import 'package:flutter/material.dart';

class MainPage extends StatefulWidget {
  const MainPage({super.key});

  @override
  State<MainPage> createState() => _MainPageState();
}

class _MainPageState extends State<MainPage> {
  int _indexPage = 0;
  @override
  Widget build(BuildContext context) {
    return Container(
      color: Colors.white,
      child: SafeArea(
        child: Scaffold(
          body: IndexedStack(
            index: _indexPage,
            children: [
              MyHomePage(title: "Home page"),
              Session34(),
              Container(
                child: Text("Profile Page"),
              ),
            ],
          ),
          bottomNavigationBar: BottomNavigationBar(
            items: const [
              BottomNavigationBarItem(
                  icon: Icon(Icons.home),
                  label: "Home"
              ),
              BottomNavigationBarItem(
                  icon: Icon(Icons.search),
                  label: "Search"
              ),
              BottomNavigationBarItem(
                  icon: Icon(Icons.people),
                  label: "Profile"
              ),
            ],
            onTap: (index){
              setState(() {
                _indexPage = index;
              });
            },
          ),
        ),

      ),
    );
  }
}
