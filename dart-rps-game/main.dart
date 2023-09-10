import 'dart:convert';
import 'dart:io';
import 'dart:math';

void main(){
  //어떤 타입을 낼 것인지 물어보는 창
  print('가위바위보 중 하나를 정해서 입력 해 주세요');

  try{

    const selectList = ['가위', '바위', '보'];

    final String userInput = (stdin.readLineSync(encoding: utf8) ?? 'ERROR').trim();

    if(!selectList.contains(userInput)){
      throw new Exception('올바른 값을 입력 해 주세요');
    }


    final cpuInput = selectList[Random().nextInt(3)];

    print('컴퓨터의 차례 입니다.');

    print(cpuInput);

    final String result = getResult(userInput, cpuInput);
    print(result);

  }catch(Exception){
    print(Exception);
  }
}

String getResult(String userInput, String cpuInput){
  const cpuWin = '컴퓨터가 승리 하였습니다';
  const userWin = '플레이어가 승리 하였습니다';
  const tie = '동점입니다.';

  String result = tie;

  switch(userInput){
    case '가위' :
      result = cpuInput == '바위' ? cpuWin : cpuInput == '보' ? userWin : tie;
      break;
    case '바위' :
      result = cpuInput == '보' ? cpuWin : cpuInput == '가위' ? userWin : tie;
      break;
    case '보' :
      result = cpuInput == '가위' ? cpuWin : cpuInput == '바위' ? userWin : tie;
      break;
    default :
      throw new Exception('올바른 값을 입력 해 주세요');
  }
  return result;
}