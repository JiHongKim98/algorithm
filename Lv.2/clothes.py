# 24/01/27

# 의상 문제

# - 종류당 하나씩
# - 최소한 한개는 입어야함
# - 입력값 => List[List[이름, 종류]...]
# - 전체 경우의 수 => (n+1)(m+1)(k+1)... -1
#   - (각 원소의 경우의 수+1)의 곱 -1
#
# - 출력 : 전체 경우의 수


def solution(clothes):
    answer = 1
    hash_ = {}
    
    for i in clothes:
        if i[1] in hash_:
            hash_[i[1]] += 1
        else:
            hash_[i[1]] = 1
    
    for k, v in hash_.items():
        answer *= (v+1)
        
    answer -= 1
    return answer