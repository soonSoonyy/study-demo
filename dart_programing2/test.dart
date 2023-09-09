import 'dart:async';

void main(){
  //async, await, Futrue : 1회만 응답을 돌려받는 경우 (서버에서 받아오는 경우)
  //async*, yield, Stream : 지속적으로 응답을 돌려 받는 경우 (일정 주기로 반복을 해야 하는 경우)
  //
  // Future<void> todo(int second) async {
  //   await Future.delayed(Duration(seconds: second));
  //   print('TODO Done in $second Second');
  // }
  //
  // todo(3);
  // todo(1);
  // todo(5);


  Stream<int> todo() async* {
    print('TODO is start');
    int counter = 0;

    while(counter <= 10){
      counter++;
      await Future.delayed(Duration(seconds: 1));
      print('TODO is Running $counter');
      yield counter;
    }
    
    print('TODO is Done');
  }


  todo().listen((event) {});
  
}

