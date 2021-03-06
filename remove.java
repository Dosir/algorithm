    /**
     * 初始版本
     * @param srcStr
     * @param removeStr
     * @return
     */
    static String removeStr(char[] srcStr, char[] removeStr){
        if (srcStr == null || removeStr ==  null){
            return null;
        }
        if (removeStr.length == 0 || srcStr.length < removeStr.length) {
            return String.valueOf(srcStr);
        }
        char[] resultStr = new char[srcStr.length];

        int count = 0;//遍历源字符串的次数
        boolean flag = true;
        while (flag){
            flag = false;
            if (count++ > 0) {
                srcStr = resultStr;
            }
            int i = 0, //源字符串的下标
                p = 0,
                k = 0; //结果字符串的下标
            for (;i < srcStr.length;i++){
                int j = 0;//被删除子串的下标
                p = i;
                while (i < srcStr.length && j < removeStr.length && srcStr[i] == removeStr[j]) {
                    j++;
                    i++;
                }
                if(j < removeStr.length){
                    resultStr[k++] = srcStr[p];
                    i = i - j;
                } else {
                    flag = true;
                    i--;
                }
            }
        }
        return String.valueOf(resultStr);
    }

    /**
     * 用到java中的内置函数实现test
     * @param srcStr
     * @param removeStr
     * @return
     */
    static String removeStr1(String srcStr, String removeStr){
        if (srcStr == null || removeStr ==  null){
            return null;
        }
        if (removeStr.length() == 0 || srcStr.length() < removeStr.length()) {
            return String.valueOf(srcStr);
        }
        StringBuilder srcSb = new StringBuilder(srcStr);
        while (true) {
            int i = srcSb.indexOf(removeStr);
            if (i == -1){
                break;
            }
            srcSb.delete(i, removeStr.length() + i);
        }

        return srcSb.toString();
    }