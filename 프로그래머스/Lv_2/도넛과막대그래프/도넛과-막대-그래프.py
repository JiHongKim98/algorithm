# 24/01/26

# 프로그래머스 - 도넛과 막대 그래프

# https://school.programmers.co.kr/learn/courses/30/lessons/258711

## - 시작 정점 조건 -> in == 0, out >= 2
## - 도넛 모양 조건 -> 시작 정점에서 나가는 간선 수 - 막대 모양수 - 8자 모양수
## - 막대 모양 조건 -> in >= 1, out == 0
## - 8자 모양 조건 -> in >= 2, out >= 2
##
## - 출력: [시작점, 도넛 모양수, 막대 모양수, 8자 모양 수]


from collections import defaultdict

def solution(edges):
    answer = [0, 0, 0, 0]

    temp = defaultdict(lambda: [0, 0])
    for x, y in edges:
        temp[x][1] += 1  # 정점 x 로 들어오는 횟수
        temp[y][0] += 1  # 정점 y 에서 나가는 횟수

    for k, v in temp.items():
        if v[0] == 0 and v[1] >= 2:  # 시작 정점
            answer[0] = k
        elif v[0] >= 1 and v[1] == 0:  # 막대 모양수
            answer[2] += 1
        elif v[0] >= 2 and v[1] >= 2:  # 8자 모양수
            answer[3] += 1
    
    answer[1] = temp[answer[0]][1] - answer[2] - answer[3]  # 도넛 모양 수
    return answer
