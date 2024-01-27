# 24/01/27

# 전화번호 목록 문제

# - 특정 문자가 다른 문자의 접두어 일경우 False
#
# - 출력: boolean


def solution(phone_book):
    answer = True
    hash_ = {}

    for i in phone_book:  # key값 저장
        hash_[i] = 0

    for j in phone_book:
        tmp = ""
        for k in j:
            tmp += k
            if tmp in hash_ and tmp != j:  # 본인이 아니고 앞번호가 hash테이블에 있을경우
                return False

    return answer
