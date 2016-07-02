function isEmail(obj){   
       reg=/^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/; 
       return reg.test(obj);
}

function isString(obj){   
    reg=/^[a-z,A-Z]+$/;   
    return reg.test(obj);
}

function isStringAndDigit(obj){   
    reg=/^[a-z,A-Z,0-9]+$/;   
    return reg.test(obj);
}