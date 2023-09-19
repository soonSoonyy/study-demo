
import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    home: Scaffold(
        appBar: AppBar(
          backgroundColor: Color(0xD8A8D2F8),
          title: const Text('Study to Flutter'),
        ),
        body: Body()),
  ));
}

class Body extends StatelessWidget {
  const Body({super.key});

  @override
  Widget build(BuildContext context) {
    return TestWidget();
  }
}

class TestWidget extends StatefulWidget {
  const TestWidget({super.key});

  @override
  State<TestWidget> createState() => _TestWidgetState();
}

class _TestWidgetState extends State<TestWidget> {
  int value = 0;

  @override
  Widget build(BuildContext context) {
    return Column(
        crossAxisAlignment: CrossAxisAlignment.center,
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Text(
            'Count : ' + '$value',
            style: const TextStyle(fontSize: 30),
          ),
          TestButton(addCounter),
        ]);
  }

  void addCounter(int addValue) {
    setState(() => value = addValue + value);
  }
}

class TestButton extends StatelessWidget {
  const TestButton(this.callback, {super.key});

  final Function(int) callback;

  @override
  Widget build(BuildContext context) {
    return Container(
        margin: const EdgeInsets.symmetric(vertical: 8),
        width: double.infinity,

        child: InkWell(
          onTap: () => callback.call(1),
          onDoubleTap: () => callback.call(10),
          onLongPress: () => callback.call(100),
          child: Center(
              child: Container(
                padding: const EdgeInsets.symmetric(vertical: 4, horizontal: 8),
                decoration: BoxDecoration(
                    border: Border.all(color: Colors.blue)),
                child: const Text(
                  'UpCounter',
                  style: TextStyle(fontSize: 20),
                ),
              )
          ),
        )
    );
  }
}
