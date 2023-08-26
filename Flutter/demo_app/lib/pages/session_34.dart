import 'package:flutter/material.dart';

import '../model/person.dart';

class Session34 extends StatefulWidget {
  const Session34({super.key});

  @override
  State<Session34> createState() => _Session34State();
}

class _Session34State extends State<Session34> {
  String name = "";
  int age = 0;
  TextEditingController? _nameController;
  TextEditingController? _ageController;
  List<Person> persons = <Person>[];

  @override
  void initState() {
    _nameController = TextEditingController(text: name);
    _ageController = TextEditingController(text: age.toString());
    // persons = [
    //   Person(name: "T2108E", age: 22),
    //   Person(name: "T2109E", age: 23),
    //   Person(name: "T2208E", age: 24),
    //   Person(name: "T2308E", age: 25),
    //   Person(name: "T2108E", age: 26),
    //   Person(name: "T2108E", age: 27),
    //   Person(name: "T2108E", age: 28),
    //   Person(name: "T2108E", age: 29),
    // ];

  }

  @override
  Widget build(BuildContext context) {
    return Container(
      child: Scaffold(
        appBar: AppBar(
          title: Text("Session 34", style: TextStyle(color: Colors.white),),
          backgroundColor: Colors.blue,
        ),
        body: Padding(
          padding: EdgeInsets.symmetric(horizontal: 20),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              TextField(
                controller: _nameController,
                keyboardType: TextInputType.text,
                decoration: InputDecoration(
                  hintText: "Input your name",
                  hintStyle: TextStyle(color: Colors.grey.withOpacity(0.5)),
                ),
                onChanged: (value){
                  name = value;
                },
              ),
              const SizedBox(
                height: 30,
              ),
              TextField(
                controller: _ageController,
                keyboardType: TextInputType.number,
                decoration: const InputDecoration(
                  hintText: "Input your age",
                  hintStyle: TextStyle(color: Colors.grey),
                ),
                onChanged: (value){
                  age = value == null || value == "" ? 0 : int.tryParse(value)!;
                },
              ),
              TextButton(
                  onPressed: (){
                    Person p = Person(name: name, age: age);
                    persons.add(p);
                    setState(() {
                    });
                  },
                  child: Container(
                    width: 100,
                    height: 50,
                    decoration: BoxDecoration(
                      borderRadius: BorderRadius.circular(20),
                      color: Colors.blue
                    ),
                    child: const Center(
                      child: Text("Save"),
                    ),
                  ),
              ),
              const SizedBox(
                height: 30,
              ),
              Expanded(
                  child: SingleChildScrollView(
                    child: Column(
                      children: persons.map((e){
                        return ListTile(
                          leading: Icon(Icons.person),
                          title: Text("${e.name}"),
                          subtitle: Text("${e.age}"),
                          // trailing: Icon(Icons.person),
                        );
                      }).toList(),
                    ),
                  )
              )
            ],
          ),
        )
      ),
    );
  }
}
