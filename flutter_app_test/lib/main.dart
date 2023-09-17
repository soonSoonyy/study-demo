import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    home: Scaffold(
        appBar: AppBar(
          title: Text('Study to Container'),
        ),
        body: Body()),
  ));
}

class Body extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Container(
      child: Row(
        children: [
          Container(
            width: 200,
            height: 200,
            color: Colors.red,
          ),
          Expanded(
              child: Container(
                width: 200,
                color: Colors.green,
          )),
          Flexible(
              child: Container(
                width: 100,
            color: Colors.blue,
          ))
          // Flexible(
          //   flex: 1,
          //   child: Container(
          //     color: Colors.red,
          //   ),
          // ),
          // Flexible(
          //   flex: 2,
          //   child: Container(
          //     color: Colors.green,
          //   ),
          // ),
          // Flexible(
          //   flex: 3,
          //   child: Container(
          //     color: Colors.blue,
          //   ),
          // ),
          // Flexible(
          //   flex: 4,
          //   child: Container(
          //     color: Colors.yellow,
          //   ),
          // ),
        ],
      ),
    );
  }
}

class CustomContainer extends StatelessWidget {
  const CustomContainer({super.key});

  @override
  Widget build(BuildContext context) {
    return Container(
      width: 300,
      height: 300,
      padding: EdgeInsets.fromLTRB(10, 12, 10, 12),
      decoration: BoxDecoration(
          color: Color(0xFFD8EEC0),
          image: const DecorationImage(
            image: NetworkImage(
                'https://flutter.github.io/assets-for-api-docs/assets/widgets/owl-2.jpg'),
            fit: BoxFit.cover,
          ),
          border: Border.all(
            color: Color(0xFFB1D28A),
            style: BorderStyle.solid,
            width: 8,
          ),
          borderRadius: BorderRadius.circular(20),
          boxShadow: [
            BoxShadow(
                color: Colors.black.withOpacity(0.3),
                offset: Offset(6, 6),
                blurRadius: 10,
                spreadRadius: 2),
            BoxShadow(
                color: Colors.blue.withOpacity(0.3),
                offset: Offset(-6, -6),
                blurRadius: 10,
                spreadRadius: 2)
          ]),
      child: Center(
          child: Container(
              color: Color(0xFFC4C1CB), child: Text('Hello, Container!'))),
    );
  }
}
