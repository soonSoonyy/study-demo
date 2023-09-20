import 'package:flutter/material.dart';
import 'package:flutter_app_test/screen/new_page.dart';

void main() {
  runApp(const MaterialApp(
    home: HomeWidget(),
  ));
}

class HomeWidget extends StatefulWidget {
  const HomeWidget({super.key});

  @override
  State<HomeWidget> createState() => _HomeWidgetState();
}

class _HomeWidgetState extends State<HomeWidget> {
  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Color(0xD8A8D2F8),
        title: const Text('Study to Flutter'),
      ),
      body: Center(
        child: TextButton(
            child: Text('Go to New Page'),
            onPressed: () => Navigator.push(
                  context,
                  MaterialPageRoute(
                      builder: (context) => const NewPage()))
        ),
      ),
    );
  }
}
