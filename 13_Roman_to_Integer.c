int valueof(char x) {
    if (x == 'I')
        return 1;

    if (x == 'V')
        return 5;

    if (x == 'X')
        return 10;

    if (x == 'L')
        return 50;

    if (x == 'C')
        return 100;

    if (x == 'D')
        return 500;

    if (x == 'M')
        return 1000;
    
    return 0;
}

int romanToInt(char* s) {
    int len = strlen(s);

    int i = 0, value = 0;

    while (i < len) {
        if (s[i] == 'I') {
            if (s[i + 1] == 'V') {
                value += 4;
                i += 2;
            } else if (s[i + 1] == 'X') {
                value += 9;
                i += 2;
            }

            else {
                value += 1;
                i++;
            }
        }

        else if (s[i] == 'X') {
            if (s[i + 1] == 'L') {
                value += 40;
                i += 2;
            } else if (s[i + 1] == 'C') {
                value += 90;
                i += 2;
            }

            else {
                value += 10;
                i++;
            }
        }

        else if (s[i] == 'C') {
            if (s[i + 1] == 'D') {
                value += 400;
                i += 2;
            } else if (s[i + 1] == 'M') {
                value += 900;
                i += 2;
            }

            else {
                value += 100;
                i++;
            }
        }

        else {
            value += valueof(s[i]);
            i++;
        }
    }

    return value;
}
