/**
 * 判断用户名是否可用
 * @type {boolean}
 */
let isUsernameValid = false;
/**
 * 判断密码是否可用
 * @type {boolean}
 */
let isPasswordValid = false;
/**
 * 判断验证密码是否与第一次输入密码相同
 * @type {boolean}
 */
let isCheckPasswordValid = false;
/**
 * 用于匹配任意位置出现的空白
 * @type {RegExp}
 */
let space_re = /\s+/g;
let password_re = /^[a-zA-Z]/;

$(function () {

    /**
     * 用于提示用户用户名相关信息
     * @type {jQuery|HTMLElement}
     */
    let username_span = $("#username-span");

    /**
     * 用于提示用户密码相关信息
     * @type {jQuery|HTMLElement}
     */
    let password_span = $("#password-span");

    /**
     * 用于提示用户验证密码相关信息
     * @type {jQuery|HTMLElement}
     */
    let check_span = $("#check-span");
    username_span.css("font-size", "small");
    password_span.css("font-size", "small");
    check_span.css("font-size", "small");

    /**
     * 通过ajax方式判断用户名是否可用
     * 以及不可用时提示错误信息
     */
    $("#username").blur(function () {
        let username = $(this).val();
        if (username.length > 3 && username.length < 21 && !space_re.test(username)) {
            $.ajax({
                type: "post",
                url: "checkUser",
                data: {username: username},
                success: function (data) {
                    if (data === null) {
                        username_span.css("color", "red");
                        username_span.html("服务器错误，请稍后尝试");
                        isUsernameValid = false;
                    } else if (data) {
                        username_span.css("color", "red");
                        username_span.html("用户名存在，请更换");
                        isUsernameValid = false;
                    } else {
                        username_span.css("color", "green");
                        username_span.html("用户名可用");
                        isUsernameValid = true;
                    }
                }
            });
        } else {
            username_span.css("color", "red");
            username_span.html("用户名长度应在4~20区间内且不能有空格");
            isUsernameValid = false;
        }
    });

    /**
     * 判断密码是否可用
     * 以及不可用时提示错误信息
     */
    $("#password").blur(function () {
        let password = $(this).val();
        if (password.length > 7 && password.length < 21 && !space_re.test(password)) {
            if (password_re.test(password)) {
                password_span.css("color", "green");
                password_span.html("密码可用");
                isPasswordValid = true;
            } else {
                password_span.css("color", "red");
                password_span.html("密码需要以字母开头");
                isPasswordValid = false;
            }
        } else {
            password_span.css("color", "red");
            password_span.html("密码长度应在8~20区间且不能有空格");
            isPasswordValid = false;
        }
    });

    /**
     * 判断验证密码是否与第一次密码输入一致
     */
    $("#check").blur(function () {
        let password = $("#password").val();
        let password_check = $(this).val();
        if (isPasswordValid) {
            if (password === password_check) {
                check_span.css("color", "green");
                check_span.html("与密码一致");
                isCheckPasswordValid = true;
            } else {
                check_span.css("color", "red");
                check_span.html("与密码不一致，请重新输入");
                isCheckPasswordValid = false;
            }
        } else {
            check_span.css("color", "red");
            check_span.html("请先正确输入密码");
            isCheckPasswordValid = false;
        }
    });

    /**
     * 设置表单提交验证
     */
    $("#user_form").submit(function () {
        return isUsernameValid && isPasswordValid && isCheckPasswordValid;
    });
});