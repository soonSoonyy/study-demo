import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';

class NewPage extends StatelessWidget {
  const NewPage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          backgroundColor: const Color(0xD8A8D2F8),
          title: const Text('Welcome New Page'),
        ),
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              TextButton(
                onPressed: () {
                  context.pop();
                },
                child: Text('Go to Back page'),
              ),
              TextButton(
                onPressed: () {
                  context.pushNamed('new2');
                },
                child: Text('Go to New Page 2'),
              ),
            ],
          ),
        ));
  }
}

class NewPage2 extends StatelessWidget {
  const NewPage2({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          backgroundColor: const Color(0xD8A8D2F8),
          title: const Text('Welcome New Page2'),
        ),
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            mainAxisSize: MainAxisSize.min,
            children: [
              TextButton(
                onPressed: () {
                  context.pop();
                },
                child: const Text('Go to Back page'),
              ),
              TextButton(
                onPressed: () {
                  context.goNamed('home');
                },
                child: const Text('Go to Home'),
              ),
            ],
          ),
        ));
  }
}
