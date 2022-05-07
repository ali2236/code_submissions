def words_check(text):
    dic = {}
    words = text.split()
    for word in words:
        wb = []
        err = 0
        for ch in word:
            if ('z' >= ch >= 'a') or ('Z' >= ch >= 'A'):
                wb.append(ch)
            else:
                err = err + 1
        if err < (len(word) / 2) or (len(word) == 1 and err == 0):
            word = ''.join(wb).title()
            count = dic.get(word)
            if count is None:
                count = 0
            count = count + 1
            dic[word] = count
    return dic