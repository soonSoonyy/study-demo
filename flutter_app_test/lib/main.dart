

import 'package:cached_network_image/cached_network_image.dart';
import 'package:english_words/english_words.dart';
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
    return CachedNetworkImage(
      imageUrl: "https://www.mashfrog.com/sites/default/files/2023-02/1920x1080_cover_B%20%281%29.png",
      placeholder: (context, url) => const CircularProgressIndicator(),
      errorWidget: (context, url, error) => const Icon(Icons.error),
    );
  }
}



class RandomWords extends StatelessWidget {
  const RandomWords({super.key});

  @override
  Widget build(BuildContext context) {
    final wordList = generateWordPairs().take(100).toList();

    return SingleChildScrollView(
      scrollDirection: Axis.vertical,
      child: Column(
        children: wordList.map((wordPair) {
          return ListTile(
            title: Text(wordPair.asPascalCase),
          );
        }).toList(),
      ),
    );
  }
}


