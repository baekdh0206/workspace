package edu.kh.array.practice;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArrayPractice {
	
	/* 실습문제 1
    길이가 9인 배열을 선언 및 할당하고, 1부터 9까지의 값을 반복문을 이용하여
    순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
    짝수 번째 인덱스 값의 합을 출력하세요. (0 번째 인덱스는 짝수로 취급)
    */
    public void practice1() {
        int[] arr = new int[9];

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
            System.out.print(arr[i] + " ");

            if (i % 2 == 0) {
                sum += arr[i];
            }
        }

        System.out.println("\n짝수 번째 인덱스 합 : " + sum);
    }

    /* 실습문제 2
    길이가 9인 배열을 선언 및 할당하고, 9부터 1까지의 값을 반복문을 이용하여
    순서대로 배열의 각 인덱스 요소에 대입하고 출력한 후
    홀수 번째 인덱스 값의 합을 출력하세요. (0 번째 인덱스는 짝수로 취급)
     */
    public void practice2() {
        int[] arr = new int[9];

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr.length - i;
            System.out.print(arr[i] + " ");

            if (i % 2 == 1) {
                sum += arr[i];
            }
        }

        System.out.println("\n홀수 번째 인덱스 합 : " + sum);
    }

    /* 실습문제 3
    사용자에게 입력 받은 양의 정수만큼 배열 크기를 할당하고
    1부터 입력 받은 값까지 배열에 초기화한 후 출력하세요.
    */
    public void practice3() {
        Scanner sc = new Scanner(System.in);

        System.out.print("양의 정수 : ");
        int[] arr = new int[sc.nextInt()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
            System.out.print(arr[i] + " ");
        }

    }

    /*실습문제 4
    정수 5개를 입력 받아 배열을 초기화 하고
    검색할 정수를 하나 입력 받아 배열에서 같은 수가 있는 인덱스를 찾아 출력.
    배열에 같은 수가 없을 경우 “일치하는 값이 존재하지 않습니다“ 출력
     */
    public void practice4() {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("입력 %d : ", i);
            arr[i] = sc.nextInt();
        }

        System.out.print("검색할 값 : ");
        int search = sc.nextInt();

        boolean flag = true;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == search) {
                System.out.println("인덱스 : " + i);
                flag = false;
                break;
            }
        }

        if (flag) System.out.println("일치하는 값이 존재하지 않습니다.");
    }


    /* 실습문제 5
    문자열을 입력 받아 문자 하나하나를 배열에 넣고 검색할 문자가 문자열에 몇 개 들어가 있는지
    개수와 몇 번째 인덱스에 위치하는지 인덱스를 출력하세요.
    ex.
    문자열 : application
    문자 : i
    application에 i가 존재하는 위치(인덱스) : 4 8
    i 개수 : 2
    */
    public void practice5() {
        // 1. 사용자에게 문자열과 문자 입력받기
        Scanner sc = new Scanner(System.in);

        System.out.print("문자열 : ");
        String str = sc.nextLine();


        // 2. 사용자가 입력한 문자열(str)을 문자 하나하나를 char배열에 넣기

        // 먼저 사용자가 입력한 문자열 길이만큼의 char배열을 할당
        char[] arr = new char[str.length()];

        // 반복문을 통해 str.charAt(i) 값을 arr[i] 에 담는 과정
        for (int i = 0; i < arr.length; i++) {
            arr[i] = str.charAt(i);
        }

        System.out.print("문자 : ");
        char ch = sc.nextLine().charAt(0);

        // 3. 검색할 문자가 문자열에 몇개가 들어있는지와 어느 인덱스에 있는지 파악

        int count = 0;    // 검색할 문자가 문자열에 몇개가 들어있는지를 세어줄 변수
        // 문자열에서 동일한 문자가 발생할 때마다 1씩 증가

        // 반복문 수행전 문자열 출력
        System.out.print(str + "에 " + ch + "가 존재하는 위치(인덱스) : ");

        // 인덱스마다 접근하기 위해 반복문 사용
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ch) { // 해당 인덱스 값이 검색될 문자와 같을 경우
                System.out.print(i + " ");    // 해당 인덱스 이어서 출력

                count++;    // 그리고 count 1증가
            }
        }

        // 위에서 print()를 사용했기 때문에 개행이 되어있지 않음
        System.out.println();    // 줄바꿈

        System.out.println(ch + "개수 : " + count);

    }


    /* 실습문제 6
    사용자가 배열의 길이를 직접 입력하여 그 값만큼 정수형 배열을 선언 및 할당하고
    배열의 크기만큼 사용자가 직접 값을 입력하여 각각의 인덱스에 값을 초기화 하세요.
    그리고 배열 전체 값을 나열하고 각 인덱스에 저장된 값들의 합을 출력하세요.
     */
    public void practice6() {
        // 1. 사용자에게 값을 입력받고 그 값만큼의 배열 선언 및 할당
        Scanner sc = new Scanner(System.in);

        System.out.print("정수 : ");
        int num = sc.nextInt();

        int[] arr = new int[num];

        // 2. 그 배열의 크기만큼 사용자가 직접 값을 입력하여 각각의 인덱스에 값을 초기화
        for (int i = 0; i < arr.length; i++) {
            System.out.print("배열 " + i + "번째 인덱스에 넣을 값 : ");
            arr[i] = sc.nextInt();
        }


        // 3. 전체 값 나열 및 총 합 출력
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            sum += arr[i];
        }

        System.out.println();
        System.out.println("총 합 : " + sum);
    }

    /* 실습문제 7
    주민등록번호를 입력 받아 char 배열에 저장한 후 출력하세요.
    단, char 배열 저장 시 성별을 나타내는 숫자 이후부터 *로 저장하세요.
    [실행 화면]
    주민등록번호(-포함) : 123456-1234567
    123456-1******

    */
    public void practice7(){
        Scanner sc = new Scanner(System.in);

        System.out.print("주민등록번호(-포함) : ");
        String input = sc.next();

        char[] arr = new char[input.length()];

        for (int i = 0; i < arr.length; i++) {

            if (i <= 7) { // 7번 인덱스 이하(생년월일, - , 성별)
                arr[i] = input.charAt(i);
            } else { // 8번 인덱스 이상부터는 *
                arr[i] = '*';
            }
            System.out.print(arr[i]);
        }
    }

    /* 실습문제 8
    3이상인 홀수를 입력 받아 배열의 중간까지는 1부터 1씩 증가하여 오름차순으로 값을 넣고,
    중간 이후부터 끝까지는 1씩 감소하여 내림차순으로 값을 넣어 출력하세요.
    단, 입력한 정수가 홀수가 아니거나 3 미만일 경우 “다시 입력하세요”를 출력하고
    다시 정수를 받도록 하세요.
    [실행 화면]
    정수 : 4
    다시 입력하세요.
    정수 : -6
    다시 입력하세요.
    정수 : 5
    1, 2, 3, 2, 1

    */
    public void practice8() {

        Scanner sc = new Scanner(System.in);

        while (true) { // 3 이상의 수가 입력 될 때 까지 무한 반봅
            // -> 3 이상이 입력되면 break문으로 종료

            System.out.print("정수 : ");
            int input = sc.nextInt();

            if (input < 3 || input % 2 == 0) { // 3 미만 또는 짝수인 경우 -> 반복
                System.out.println("다시 입력하세요.");

            } else {
                // 입력 받은 정수 만큼의 크기를 가지는 배열 생성
                int[] arr = new int[input];

                int num = 0; // arr 배열에 대입될 값

                for (int i = 0; i < arr.length; i++) {
                    if (i <= arr.length / 2) { // 중간 이전 까지 -> 증가
                        arr[i] = ++num;

                    } else { // 중간 이후 -> 감소
                        arr[i] = --num;
                    }

                    // 출력 시 , 추가 (단, 마지막 제외)
                    if (i == arr.length - 1) { // 마지막 바퀴
                        System.out.print(arr[i]);

                    } else {
                        System.out.print(arr[i] + ", ");
                    }

                }
                break; // while 반복 멈춤
            }
        }
    }

    /* 실습문제 9
    10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고,
    1~10 사이의 난수를 발생시켜 배열에 초기화한 후 출력하세요.
    [실행 화면]
    발생한 난수 : 9 7 6 2 5 10 7 2 9 6
    */
    public void practice9(){
        int[] arr = new int[10];

        for(int i=0 ; i<arr.length ; i++){
            arr[i] = (int)(Math.random() * 10 + 1);
        }

        System.out.print("발생한 난수 : ");
        for(int i=0 ; i<arr.length ; i++){
            System.out.print(arr[i] + " ");
        }
    }

    /* 실습문제 10
    10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고,
    1~10 사이의 난수를 발생시켜 배열에 초기화 후
    배열 전체 값과 그 값 중에서 최대값과 최소값을 출력하세요.
    [실행 화면]
    발생한 난수 : 5 3 2 7 4 8 6 10 9 10
    최대값 : 10
    최소값 : 2

    */
    public void practice10(){
// 1. 10개의 값을 저장할 수 있는 정수형 배열 선언 및 할당
        int[] arr = new int[10];

        // 2. 각 인덱스에 1부터 10 사이의 난수를 발생시켜 초기화 후 출력
        for(int i=0; i<arr.length; i++) {
            arr[i] = (int)(Math.random() * 10 + 1);

            System.out.print(arr[i] + " ");
        }

        System.out.println(); // 개행

        // 3. 반복문을 통해 최대값 최소값 알아내기
        int max = 1;  // 최소값을 담아줄 변수
        int min = 10; // 최대값을 담아줄 변수

        for(int i=0; i<arr.length; i++) {

            if(arr[i] > max) { // 해당 인덱스의 값이 max 보다 큰 경우
                max = arr[i]; // 해당 값을 max 변수에 담아줌
            }

            if(arr[i] < min) { // 해당 인덱스의  값이 min 보다 작은 경우
                min = arr[i]; // 해당 값을 min 변수에 담아줌
            }
        }

        System.out.println("최대값 : " + max);
        System.out.println("최소값 : " + min);
    }

    /* 실습문제 11
    10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고
    1~10 사이의 난수를 발생시켜 중복된 값이 없게 배열에 초기화한 후 출력하세요.
    */
    public void practice11(){
        // 1. 10개의 값을 저장할 수 있는 정수형 배열 선언 및 할당
        int[] arr = new int[10];

        // 2. 각 인덱스 값에 1부터 10 사이의 난수를 발생시키는데 이때 중복이 없도록
        for(int i=0; i<arr.length; i++) {

            arr[i] = (int)(Math.random() * 10 + 1);

            for(int j=0; j<i; j++) { // 중복 제거
                if(arr[i] == arr[j]) {
                    i--;
                    break;
                }
            }
        }

        // 3. 출력
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /* 실습문제 12
    로또 번호 자동 생성기 프로그램을 만들기.
    (중복 값 없이 오름차순으로 정렬하여 출력하세요.)
    [실행 화면]
    3 4 15 17 28 40
    */
    public void practice12(){
        // 1. 크기가 6인 정수형 배열 선언 및 할당
        int[] lotto = new int[6];

        // 2. 배열에 중복값없이 1부터 45사이의 난수 초기화
        for(int i=0; i<lotto.length; i++) {
            lotto[i] = (int)(Math.random() * 45 + 1);

            for(int j=0; j<i; j++) { // 중복 제거
                if(lotto[i] == lotto[j]) {
                    i--;
                    break;
                }
            }
        }

        // 3. 오름차순 정렬(선택정렬)
        for(int i=0; i<lotto.length-1; i++) { // 비교 주체
            for(int j=i+1; j<lotto.length; j++) { // 비교 대상
                if(lotto[i] > lotto[j]) { // 비교 주체가 비교 대상보다 큰 경우 값을 바꿔줘야됨

                    int temp = lotto[i];
                    lotto[i] = lotto[j];
                    lotto[j] = temp;
                }
            }
        }
        

        // 4. 출력
        for(int i=0; i<lotto.length; i++) {
            System.out.print(lotto[i] + " ");
        }
    }

    /* 실습문제 13
    문자열을 입력 받아 문자열에 어떤 문자가 들어갔는지 배열에 저장하고
    문자의 개수와 함께 출력하세요. (중복 제거)
    [실행 화면]
    문자열 : application
    문자열에 있는 문자 : a, p, l, i, c, t, o, n
    문자 개수 : 8
    */
    public void practice13(){
        // 1. 사용자에게 문자열 입력받기
        Scanner sc = new Scanner(System.in);

        System.out.print("문자열 : ");
        String str = sc.nextLine();

        // 2. 해당 문자열의 문자들을 char[]에 담기
        char[] arr = new char[str.length()];

        for(int i=0; i<arr.length; i++) {
            arr[i] = str.charAt(i);
        }

        // 3. char배열에서 중복값 존재할 경우 출력X,
        int count = 0; // 문자 개수 카운트

        System.out.print("문자열에 있는 문자 : ");

        for(int i=0; i<arr.length; i++) {

            boolean flag = true; // 중복 체크용 flag

            for(int j=0; j<i; j++) {
                if(arr[i] == arr[j]) {
                    flag = false; // 중복이발생했을 때
                    break;
                }
            }

            if(flag) { // 중복이 발생하지 않았을 경우

                if(i == 0) {
                    System.out.print(arr[i]);
                }else {
                    System.out.print(", " + arr[i]);
                }

                count++;
            }
        }

        System.out.println();
        System.out.println("문자 개수 : " + count);
    }


	 /* 실습문제 14
    사용자가 입력한 배열의 길이만큼의 String 배열을 선언 및 할당하고
    배열의 인덱스에 넣을 값 역시 사용자가 입력하여 초기화 하세요.
    단, 사용자에게 배열에 값을 더 넣을지 물어보고 몇 개를 더 입력할 건지,
    늘린 곳에 어떤 데이터를 넣을 것인지 받으세요.
    사용자가 더 이상 입력하지 않겠다고 하면 배열 전체 값을 출력하세요.
     */
	
	public void practice14() {
		Scanner sc = new Scanner(System.in);
		
		// 1. 첫 배열 크기 지정
		System.out.print("배열의 크기를 입력 하시오 : ");
		int size = sc.nextInt(); // 입력 버퍼에 개행문자(엔터)가 남음
		
		sc.nextLine(); // 입력 버퍼에 남은 개행문자(엔터) 제거

		
		// 2. 첫 배열 생성
		String[] books = new String[size];
		
		
		// 3. 첫 배열에 저장할 문자열 입력 받기
		for(int i=0 ; i<books.length ; i++) {
			System.out.print((i+1) + "번째 문자열 : "  );
			books[i] = sc.nextLine(); // 입력 버퍼에서 다음 엔터까지 읽어옴
		}
		
		// 4. n이 입력될 때 까지 무한 반복 -> n 입력 시 break
		while(true) {
			
			System.out.print("더 값을 입력하시겠습니까?(Y/N) :  ");
			char ch = sc.nextLine().charAt(0);
			
			if(ch == 'N') {
				break;
			}
			
			// 5. 더 입력 받을 개수 입력
			System.out.print("더 입력하고 싶은 개수 : ");
			int addSize = sc.nextInt();
			sc.nextLine(); // 입력 버퍼 개행문자 제거
			
			// 6. 기존 배열보다 늘어난 개수만큼 큰 새 배열 생성
			String newBooks[] = new String[books.length + addSize];
			
			// 7. 깊은 복사를 통해 기존 배열 내용을 새 배열로 복사
			System.arraycopy(books, 0, newBooks, 0, books.length);
			
			
			// 8. 새 배열의 빈칸 부터 새로운 입력을 받아서 저장
			for(int i=books.length ; i<newBooks.length ; i++) {
				System.out.print( (i+1) + "번째 문자열 : " );
				newBooks[i] = sc.nextLine();
			}
			
			// 9. 기존 참조배열 books에 newBooks의 주소를 얕은 복사
			books = newBooks;
			
		} // while 종료
		
		// 10. 배열에 저장된 모든 값 출력
		System.out.println(Arrays.toString(books));
		
		
	}
	
	
	
	
	// 스캐너 사용법
	public void scannerEx() {
		Scanner sc = new Scanner(System.in);
		
		// 1) next() : 한 단어 (띄어쓰기, 엔터를 만나면 입력 종료)
		//    nextLine() : 한 문장 (엔터를 만나면 입력 종료)
		
		
		System.out.print("입력 : "); // hello world
//		String str = sc.next();
		String str = sc.nextLine();
		
		System.out.println(str); // next() : hello
								 // nextLine() : hello world
		
		// 2) 스캐너 입력 버퍼와 nextXXX의 의미
		
		// 입력 -> 입력 버퍼에 저장 -> nextXXX() 통해 버퍼 내용을 읽어옴
		
		//					입력 버퍼			nextXXX() 			후처리
		// nextLine() :  hello world(엔터) -> hello world(엔터) -> 엔터 제거 
		// (다음 엔터)
		
		// nextInt()  : 	100(엔터)	   ->   100			
		// (다음 정수) 
		// ** next(), nextDouble(), nextInt() 등
		//    모두 입력 버퍼에서 (엔터)를 제외 하고 내용만 읽어옴 **
		
		
		System.out.println("------------------------------");
		
		System.out.print("nextInt() : "); // 입력버퍼 :  [  100(엔터)  ]
		int a = sc.nextInt();
		// 100     // 입력버퍼 :  [  (엔터)  ]
		
		// !문제 해결!
		sc.nextLine(); // 입력버퍼 :  [   ]
		
		System.out.println("nextLine() : "); // 입력버퍼 :  [  a b c(엔터)  ]
		String s = sc.nextLine();
		// a b c   // 입력버퍼 :  [   ]
		
		
		
		System.out.println("종료");
		
		// [문제점]
		// nextInt() 이후 입력 버퍼에 남아있는 (엔터) 때문에
		// 다음 nextLine() 수행 시 버퍼에 남아있는 (엔터)를 읽어버리기 때문에
		// 추가적인 입력을 시도하지 못하고 다음 코드로 넘어가는 문제 발생.
		
		// [해결방법]
		// 입력을 위한 nextLine() 수행 전 
		// 입력 버퍼에서 (엔터)를 제거
		// -> 빈 공간에 sc.nextLine() 구문을 한번 작성하면 (엔터)가 제거됨
		
	}
	
	   /* 실습문제 15
    3행 3열짜리 문자열 배열을 선언 및 할당하고
    인덱스 0행 0열부터 2행 2열까지 차례대로 접근하여 “(0, 0)”과 같은 형식으로 저장 후 출력하세요.
    [실행 화면]
    (0, 0)(0, 1)(0, 2)
    (1, 0)(1, 1)(1, 2)
    (2, 0)(2, 1)(2, 2)
     */
    public void practice15(){
        String[][] arr = new String[3][3];

        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++) {
                arr[i][j] = "(" + i + ", " + j + ")";
            }
        }

        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    /* 실습문제 16
    4행 4열짜리 정수형 배열을 선언 및 할당하고
    1) 1 ~ 16까지 값을 차례대로 저장하세요.
    2) 저장된 값들을 차례대로 출력하세요.
    [실행 화면]
    1 2 3 4
    5 6 7 8
    9 10 11 12
    13 14 15 16
     */
    public void practice16(){
        int[][] arr = new int[4][4];

        int value = 1;

        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++) {
                arr[i][j] = value++;
            }
        }

        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++) {
                System.out.printf("%2d ", arr[i][j]);
            }
            System.out.println();
        }
    }

    /* 실습문제 17
    4행 4열짜리 정수형 배열을 선언 및 할당하고
    1) 16 ~ 1과 같이 값을 거꾸로 저장하세요.
    2) 저장된 값들을 차례대로 출력하세요.
    [실행 화면]
    16 15 14 13
    12 11 10 9
    8 7 6 5
    4 3 2 1
     */
    public void practice17(){
        int[][] arr = new int[4][4];

        int value = 16;

        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++) {
                arr[i][j] = value--;
            }
        }

        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++) {
                System.out.printf("%2d ", arr[i][j]);
            }
            System.out.println();
        }
    }
	
	
	
    /* 실습문제 18
    4행 4열 2차원 배열을 생성하여 0행 0열부터 2행 2열까지는 1~10까지의 임의의 정수 값 저장 후
    아래의 내용처럼 처리하세요.
    [실행 화면]
     9  3  7 19
     3  6  9 18
     6 10 10 26
    18 19 26 63
     */
	public void practice18() {
		
		// 1. 4행 4열 2차원 배열 생성
		int[][] arr = new int[4][4];
		
		final int LAST_ROW_INDEX = arr.length - 1; // 행 마지막 인덱스
		final int LAST_COL_INDEX = arr[0].length - 1; // 열 마지막 인덱스
		
		// 2. 0행 0열 ~ 2행 2열까지 1~10 사이 난수 대입

		Random random = new Random();
//		random.nextInt(); 0이상 1미만 정수
		
		for(int row=0 ; row < LAST_ROW_INDEX ; row++) {
			for(int col=0 ; col < LAST_COL_INDEX ; col++) {
				arr[row][col] = random.nextInt(10) + 1;
				
				// 3행 3열에 발생된 난수 모두 누적
				arr[LAST_ROW_INDEX][LAST_COL_INDEX] += arr[row][col];
				
				// 난수 대입과 동시에 해당 행/열의 끝에 누적
				arr[row][LAST_COL_INDEX] += arr[row][col]; // 각 행 마지막 열에 누적
				arr[LAST_ROW_INDEX][col] += arr[row][col]; // 각 열 마지막 행에 누적
			}
		}
		
		// 출력용 2중 for문
		for(int row=0 ; row <= LAST_ROW_INDEX ; row++) {
			for(int col=0 ; col <= LAST_COL_INDEX ; col++) {
				System.out.printf("%3d", arr[row][col]);
			}
			System.out.println();
		}
	}
	
	
    /* 실습문제 19
    2차원 배열의 행과 열의 크기를 사용자에게 직접 입력받되, 1~10사이 숫자가 아니면
    “반드시 1~10 사이의 정수를 입력해야 합니다.” 출력 후 다시 정수를 받게 하세요.
    크기가 정해진 이차원 배열 안에는 영어 대문자가 랜덤으로 들어가게 한 뒤 출력하세요.
    (char형은 숫자를 더해서 문자를 표현할 수 있고 65는 A를 나타냄, 알파벳은 총 26글자)
    [실행 화면]
    행 크기 : 5
    열 크기 : 4
    T P M B
    U I H S
    Q M B H
    H B I X
    G F X I
     */
    public void practice19(){
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.print("행 크기 : ");
            int row = sc.nextInt();
            System.out.print("열 크기 : ");
            int col = sc.nextInt();

            if((row < 1 || row >10) || (col < 1 || col >10)) {
                System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다.");

            }else{
                char[][] arr = new char[row][col];

                for(int i=0; i<arr.length; i++) {
                    for(int j=0; j<arr[i].length; j++) {
                        arr[i][j] = (char)((int)(Math.random() * 26 + 65));
                    }
                }

                for(int i=0; i<arr.length; i++) {
                    for(int j=0; j<arr[i].length; j++) {
                        System.out.print(arr[i][j] + " ");
                    }
                    System.out.println();
                }
                break;
            }
        }
    }

    /* 실습문제 20
    사용자에게 행의 크기를 입력 받고 그 수만큼의 반복을 통해 열의 크기도 받아
    문자형 가변 배열을 선언 및 할당하세요.
    그리고 각 인덱스에 ‘a’부터 총 인덱스의 개수만큼 하나씩 늘려 저장하고 출력하세요.
    [실행 화면]
    행의 크기 : 4
    0열의 크기 : 2
    1열의 크기 : 6
    2열의 크기 : 3
    3열의 크기 : 5
    a b
    c d e f g h
    i j k
    l m n o p
     */
    public void practice20(){
        Scanner sc = new Scanner(System.in);

        System.out.print("행의 크기 : ");
        int row = sc.nextInt();

        char[][] arr = new char[row][];

        for(int i=0; i<arr.length; i++) {
            System.out.print(i + "행의 크기 : ");
            int col = sc.nextInt();

            arr[i] = new char[col];
        }

        // 값 초기화
        char value = 'a';
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++) {
                arr[i][j] = value++;
            }
        }

        // 출력
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    /* 실습문제 21
    1차원 문자열 배열에 학생 이름 초기화되어 있다.
    3행 2열 짜리 2차원 문자열 배열 2개를 새로 선언 및 할당하여
    학생 이름을 2차원 배열에 순서대로 저장하고 아래와 같이 출력하시오.
    (첫 번째 2차원 배열이 모두 저장된 경우 두 번째 2차원 배열에 저장 진행)

    [실행 화면]
    == 1분단 ==
    강건강 남나나
    도대담 류라라
    문미미 박보배
    == 2분단 ==
    송성실 윤예의
    진재주 차천축
    피풍표 홍하하
     */
    public void practice21(){
        String[] students = { "강건강", "남나나", "도대담", "류라라", "문미미", "박보배", "송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하" };

        String[][] arr1 = new String[3][2];
        String[][] arr2 = new String[3][2];

        int index = 0; // students 배열에서 0 부터 1씩 증가하며 학생들을 선택하는 용도의 변수

        System.out.println("== 1분단 ==");
        for(int row=0 ; row<arr1.length ; row++) {
            for(int col=0 ; col<arr1[row].length ; col++) {

                arr1[row][col] = students[index];
                // students배열 index 번째 학생을 arr1[row][col]에 대입

                index++;

                System.out.print(arr1[row][col] + " ");
            }
            System.out.println();// 줄바꿈
        }

        System.out.println("== 2분단 ==");
        for(int row=0 ; row<arr2.length ; row++) {
            for(int col=0 ; col<arr2[row].length ; col++) {

                arr2[row][col] = students[index];
                // students배열 index 번째 학생을 arr2[row][col]에 대입

                index++;

                System.out.print(arr2[row][col] + " ");
            }
            System.out.println();// 줄바꿈
        }
    }

    /* 실습문제 22
    위 문제에서 자리 배치한 것을 가지고 학생 이름을 검색하여
    해당 학생이 어느 자리에 앉았는지 출력하세요.
    [실행 화면]
    == 1분단 ==
    강건강 남나나
    도대담 류라라
    문미미 박보배
    == 2분단 ==
    송성실 윤예의
    진재주 차천축
    피풍표 홍하하
    ============================
    검색할 학생 이름을 입력하세요 : 차천축
    검색하신 차천축 학생은 2분단 2번째 줄 오른쪽에 있습니다.
     */
    public void practice22(){
        Scanner sc = new Scanner(System.in);
        String[] students = { "강건강", "남나나", "도대담", "류라라", "문미미", "박보배", "송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하" };

        String[][] seat1 = new String[3][2];
        String[][] seat2 = new String[3][2];

        int index = 0;
        // 1분단이 끝나고 2분단이 시작될 때도 이어서 들어가야하기 때문에
        // 학생을 이어서 셀 수 있도록 index 변수 생성

        // 1분단 학생 대입
        System.out.println("== 1분단 ==");
        for (int i = 0; i < seat1.length; i++) {

            for (int j = 0; j < seat1[i].length; j++) {

                seat1[i][j] = students[index++];
                System.out.print(seat1[i][j] + " ");
            }
            System.out.println();
        }

        // 2분단 학생 대입
        System.out.println("== 2분단 ==");
        for (int i = 0; i < seat2.length; i++) {

            for (int j = 0; j < seat2[i].length; j++) {

                seat2[i][j] = students[index++];
                System.out.print(seat2[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("============================");

        System.out.print("검색할 학생 이름을 입력하세요 : ");
        String searchName = sc.next();


        // 검색된 분단, 줄, 좌우 방향을 지정할 변수 선언
        int seat = 0;
        int row = 0;
        String direction = null;

        for(int i=0; i<seat1.length ; i++) {

            for(int j=0; j<seat1[i].length ; j++) {

                if(seat1[i][j].equals(searchName)) {
                    // 1분단에 일치하는 이름이 있을 경우
                    seat = 1;
                    row = i+1;
                    direction = j == 0 ? "왼쪽" : "오른쪽"; // 삼항 연산자

                }else if(seat2[i][j].equals(searchName)) {
                    // 2분단에 일치하는 이름이 있을 경우
                    seat = 2;
                    row = i+1;
                    direction = j == 0 ? "왼쪽" : "오른쪽"; // 삼항 연산자
                }
            }
        }


        if(seat != 0) { // 검색 결과가 있을 경우
            System.out.printf("검색하신 %s 학생은 %d분단 %d번째 줄 %s에 있습니다.\n",
                    searchName, seat, row, direction);
        }else {
            System.out.println("검색한 학생이 존재하지 않습니다.");
        }
    }

    /* 실습문제 23
    String 2차원 배열 6행 6열을 만들고 행의 맨 위와 제일 앞 열은 각 인덱스를 저장하세요.
    그리고 사용자에게 행과 열을 입력 받아 해당 좌표의 값을 “X”로 변환해 2차원 배열을 출력하세요.
    [실행 화면]
    행 인덱스 입력 : 4
    열 인덱스 입력 : 2
      0 1 2 3 4
    0
    1
    2
    3
    4 X

     */
    public void practice23(){
        Scanner sc = new Scanner(System.in);
        String[][] board = new String[6][6]; // String 6행 6열 2차원 배열 생성

        // 행과 열의 인덱스를 표시하는 부분에 인덱스 대입
        for (int i = 0; i < board.length-1; i++) {
            board[0][i+1] = i + "";
            board[i+1][0] = i + "";

            // '0' == 60번
        }


        int rowIndex = 0;
        int colIndex = 0;

        while(true) {
            System.out.print("행 인덱스 입력 : ");
            rowIndex = sc.nextInt();

            if(rowIndex < 0 || rowIndex > 4) {
                System.out.println("0~4사이 인덱스를 입력해주세요.");
                continue;
            }

            break;
        }


        while(true) {
            System.out.print("열 인덱스 입력 : ");
            colIndex = sc.nextInt();

            if(colIndex < 0 || colIndex > 4) {
                System.out.println("0~4사이 인덱스를 입력해주세요.");
                continue;
            }

            break;
        }


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                if (i == rowIndex && j == colIndex) { // 사용자가 입력한 행과 열의 인덱스 값이 같을 때
                    board[i + 1][j + 1] = "X";
                    // 실제 2차원 배열의 인덱스에 1을 추가한 값이 화면에 표시된 인덱스
                }

                if(board[i][j] == null){
                    board[i][j] = " ";
                }

                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    /* 실습문제 24
    실습문제9와 내용은 같으나 행 입력 시 99가 입력되지 않으면 무한 반복이 되도록 구현하세요.
     */
    public void practice24(){
        Scanner sc = new Scanner(System.in);
        String[][] board = new String[6][6]; // String 6행 6열 2차원 배열 생성

        // 행과 열의 인덱스를 표시하는 부분에 인덱스 대입
        for (int i = 0; i < board.length-1; i++) {
            board[0][i+1] = i + "";
            board[i+1][0] = i + "";

            // '0' == 60번
        }

        int rowIndex = 0;
        int colIndex = 0;

        while(true) {
            while (true) {
                System.out.print("행 인덱스 입력 : ");
                rowIndex = sc.nextInt();

                if(rowIndex == 99){
                    break;
                }

                if (rowIndex < 0 || rowIndex > 4) {
                    System.out.println("0~4사이 인덱스를 입력해주세요.");
                    continue;
                }

                break;
            }

            if(rowIndex == 99){
                System.out.println("프로그램 종료");
                break;
            }

            while (true) {
                System.out.print("열 인덱스 입력 : ");
                colIndex = sc.nextInt();

                if (colIndex < 0 || colIndex > 4) {
                    System.out.println("0~4사이 인덱스를 입력해주세요.");
                    continue;
                }

                break;
            }


            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {

                    if (i == rowIndex && j == colIndex) { // 사용자가 입력한 행과 열의 인덱스 값이 같을 때
                        board[i + 1][j + 1] = "X";
                        // 실제 2차원 배열의 인덱스에 1을 추가한 값이 화면에 표시된 인덱스
                    }

                    if (board[i][j] == null) {
                        board[i][j] = " ";
                    }

                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }

        }
    }
	
	
	
	
}
