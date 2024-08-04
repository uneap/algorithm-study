https://www.acmicpc.net/problem/11048

1. 이동되었다고 가정하고, 이전 위치 중 가장 큰 값으로 초기화 하면서 누적시킴
2. N,M이 되었을 때 누적시킨 값 리턴

https://www.acmicpc.net/problem/21941

1. 문자열에 따른 점수 저장, 문자 하나 지우면 점수 하나 얻음
2. 순회하면서 해당 문자 문자 하나 지울 수 있으니, Math.max(dp[i + 1], dp[i] + 1)
3. startsWith 문자열이라면, Math.max(dp[i + 문자열 길이], dp[i] + 문자열이 가리키는 점수)
