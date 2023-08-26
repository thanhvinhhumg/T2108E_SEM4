import 'package:flutter/material.dart';

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  int _counter = 0;

  void _incrementCounter() {
    setState(() {
      _counter++;
    });
  }
  void _decrementCounter() {
    setState(() {
      _counter--;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      color: Colors.white,
      child: SafeArea(
        child: Scaffold(
          appBar: AppBar(
            backgroundColor: Theme.of(context).colorScheme.inversePrimary,
            title: Text(widget.title),
          ),
          body: Column(
            children: [
              Container(
                width: double.maxFinite,
                height: 200,
                color: Colors.grey,
                child: const Align(
                  alignment: Alignment.center,
                  child: Text(
                    "Hello T2108E",
                    style: TextStyle(
                        fontWeight: FontWeight.bold,
                        fontSize: 30,
                        color: Colors.red
                    ),
                  ),
                ),
              ),
              SizedBox(
                height: 50,
              ),
              const Center(
                child: Text(
                  "Hello T2108E FPT",
                  style: TextStyle(
                      fontWeight: FontWeight.bold,
                      fontSize: 30,
                      color: Colors.red
                  ),
                ),
              ),
              Padding(
                  padding: EdgeInsets.only(left: 10, right: 30,bottom: 20),
                child: Container(
                  color: Colors.red.withOpacity(0.5),
                  height: 100,
                ),
              ),
              Expanded(
                  child: Row(
                    children: [
                      Container(
                        width: 100,
                        height: double.maxFinite,
                        color: Colors.pink,
                      ),
                      Spacer(),
                      Container(
                        width: 100,
                        height: double.maxFinite,
                        color: Colors.blue,
                      )

                    ],
                  )
              ),
            ],
          )
           // This trailing comma makes auto-formatting nicer for build methods.
        ),
      ),
    );
  }
}