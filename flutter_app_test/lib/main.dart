import 'package:flutter/material.dart';
import 'package:flutter_app_test/screen/new_page.dart';
import 'package:go_router/go_router.dart';

void main() {
  runApp(MaterialApp.router(
    routerConfig: GoRouter(
      initialLocation: '/',
      routes:[
        GoRoute(
            path:'/',
            name:'home',
            builder: (context, _) => const HomeWidget(),
        ),
        GoRoute(path:'/new1', name:'new1', builder: (context, _) => const NewPage()),
        GoRoute(path:'/new2', name:'new2', builder: (context, _) => const NewPage2()),
      ]
    ),
  )
  );
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
        backgroundColor: const Color(0xD8A8D2F8),
        title: const Text('Study to Flutter'),
      ),
      body: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: [
          Center(
            child: TextButton(
                child: const Text('Go to New Page1'),
                onPressed: () =>
                    context.pushNamed('new1')
            ),
          ),
          Center(
            child: TextButton(
                child: const Text('Go to New Page2'),
                onPressed: () =>
                    context.pushNamed('new2')
            ),
          ),
        ],
      ),
    );
  }
}
