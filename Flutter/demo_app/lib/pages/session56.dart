
import 'package:flutter/material.dart';

class Session56 extends StatefulWidget {
  const Session56({super.key});

  @override
  State<Session56> createState() => _Session56State();
}

class _Session56State extends State<Session56> {
  List<String> names = ['Nguyen Van A', 'Nguyen Van B', 'Nguyen Van C', 'Nguyen Van D', 'Nguyen Van E', 'Nguyen Van F'];

  @override
  Widget build(BuildContext context) {
    return Container(
      color: Colors.white,
      child: SafeArea(
        child: Scaffold(
          body: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Stack(
                children: [
                  Container(
                    width: 350,
                    height: 350,
                    color: Colors.red,
                  ),
                  Container(
                    width: 250,
                    height: 250,
                    color: Colors.blue,
                  ),
                  Positioned(
                      bottom: 20 ,
                      left: 30,
                      child: Container(
                        width: 150,
                        height: 150,
                        color: Colors.green,
                      )
                  )
                ],
              ),
              SizedBox(
                height: 30,
              ),
              Container(
                 height: 50,
                 child: ListView(
                   scrollDirection: Axis.vertical,
                   children: names.map((e) => Text(e)).toList(),
                 ),
              ),
              Expanded(
                  child: GridView.count(
                      crossAxisCount: 3,
                     mainAxisSpacing: 10,
                     crossAxisSpacing: 10,
                     children: [
                       Container(
                         color: Colors.red,
                       ),
                       Container(
                         color: Colors.green,
                       ),
                       Container(
                         color: Colors.orange,
                       ),
                       Container(
                         color: Colors.pink,
                       ),
                       Container(
                         color: Colors.greenAccent,
                       ),
                       Container(
                         color: Colors.blue,
                       ),
                     ],
                  )
              )
            ],
          ),
        ),
      ),
    );
  }
}
