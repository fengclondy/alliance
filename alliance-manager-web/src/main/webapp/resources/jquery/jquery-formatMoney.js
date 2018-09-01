/** 
 * 金额按千位逗号分割 
 * @character_set UTF-8 
 * @author Jerry.li(hzjerry@gmail.com) 
 * @version 1.2014.08.24.2143 
 *  Example 
 *  <code> 
 *      alert($.formatMoney(1234.345, 2)); //=>1,234.35 
 *      alert($.formatMoney(-1234.345, 2)); //=>-1,234.35 
 *      alert($.unformatMoney(1,234.345)); //=>1234.35 
 *      alert($.unformatMoney(-1,234.345)); //=>-1234.35 
 *  </code> 
 */  
;(function($)  
{  
    $.extend({  
        /** 
         * 数字千分位格式化 
         * @public 
         * @param mixed mVal 数值 
         * @param int iAccuracy 小数位精度(默认为2) 
         * @return string 
         */  
        formatMoney:function(mVal, iAccuracy){  
            var fTmp = 0.00;//临时变量  
            var iFra = 0;//小数部分  
            var iInt = 0;//整数部分  
            var aBuf = new Array(); //输出缓存  
            var bPositive = true; //保存正负值标记(true:正数)  
            /** 
             * 输出定长字符串，不够补0 
             * <li>闭包函数</li> 
             * @param int iVal 值 
             * @param int iLen 输出的长度 
             */  
            function funZero(iVal, iLen){  
                var sTmp = iVal.toString();  
                var sBuf = new Array();  
                for(var i=0,iLoop=iLen-sTmp.length; i<iLoop; i++)  
                    sBuf.push('0');  
                sBuf.push(sTmp);  
                return sBuf.join('');  
            };  
  
            if (typeof(iAccuracy) === 'undefined')  
                iAccuracy = 2;  
            bPositive = (mVal >= 0);//取出正负号  
            fTmp = (isNaN(fTmp = parseFloat(mVal))) ? 0 : Math.abs(fTmp);//强制转换为绝对值数浮点  
            //所有内容用正数规则处理  
            iInt = parseInt(fTmp); //分离整数部分  
            iFra = parseInt((fTmp - iInt) * Math.pow(10,iAccuracy) + 0.5); //分离小数部分(四舍五入)  
  
            do{  
                aBuf.unshift(funZero(iInt % 1000, 3));  
            }while((iInt = parseInt(iInt/1000)));  
            aBuf[0] = parseInt(aBuf[0]).toString();//最高段区去掉前导0 
            
			var temp = new Array();
			if(iAccuracy > 0) {
				temp.push('.');
				
				if(0 === iFra) {
					for(var i=0; i<iAccuracy;i++)
						temp.push('0');
				} else {
					temp.push(funZero(iFra, iAccuracy));
				}
			}
            
            return ((bPositive)?'':'-') + aBuf.join(',') + temp.join('');  
        },  
        /** 
         * 将千分位格式的数字字符串转换为浮点数 
         * @public 
         * @param string sVal 数值字符串 
         * @return float 
         */  
        unformatMoney:function(sVal){  
            var fTmp = parseFloat(sVal.replace(/,/g, ''));  
            return (isNaN(fTmp) ? 0 : fTmp);  
        },


        /**
         * 加法运算，避免数据相加小数点后产生多位数和计算精度损失。
         *
         * @param num1加数1 | num2加数2
         */
        numAdd:function(num1, num2) {
            var baseNum, baseNum1, baseNum2;
            try {
                baseNum1 = num1.toString().split(".")[1].length;
            } catch (e) {
                baseNum1 = 0;
            }
            try {
                baseNum2 = num2.toString().split(".")[1].length;
            } catch (e) {
                baseNum2 = 0;
            }
            baseNum = Math.pow(10, Math.max(baseNum1, baseNum2));
            return (num1 * baseNum + num2 * baseNum) / baseNum;
        },
        /**
         * 加法运算，避免数据相减小数点后产生多位数和计算精度损失。
         *
         * @param num1被减数  |  num2减数
         */
        numSub:function(num1, num2) {
            var baseNum, baseNum1, baseNum2;
            var precision;// 精度
            try {
                baseNum1 = num1.toString().split(".")[1].length;
            } catch (e) {
                baseNum1 = 0;
            }
            try {
                baseNum2 = num2.toString().split(".")[1].length;
            } catch (e) {
                baseNum2 = 0;
            }
            baseNum = Math.pow(10, Math.max(baseNum1, baseNum2));
            precision = (baseNum1 >= baseNum2) ? baseNum1 : baseNum2;
            return ((num1 * baseNum - num2 * baseNum) / baseNum).toFixed(precision);
        },
        /**
         * 乘法运算，避免数据相乘小数点后产生多位数和计算精度损失。
         *
         * @param num1被乘数 | num2乘数
         */
        numMulti:function(num1, num2) {
            var baseNum = 0;
            try {
                baseNum += num1.toString().split(".")[1].length;
            } catch (e) {
            }
            try {
                baseNum += num2.toString().split(".")[1].length;
            } catch (e) {
            }
            return Number(num1.toString().replace(".", "")) * Number(num2.toString().replace(".", "")) / Math.pow(10, baseNum);
        },
        /**
         * 除法运算，避免数据相除小数点后产生多位数和计算精度损失。
         *
         * @param num1被除数 | num2除数
         */
        numDiv:function(num1, num2) {
            var baseNum1 = 0, baseNum2 = 0;
            var baseNum3, baseNum4;
            try {
                baseNum1 = num1.toString().split(".")[1].length;
            } catch (e) {
                baseNum1 = 0;
            }
            try {
                baseNum2 = num2.toString().split(".")[1].length;
            } catch (e) {
                baseNum2 = 0;
            }
            with (Math) {
                baseNum3 = Number(num1.toString().replace(".", ""));
                baseNum4 = Number(num2.toString().replace(".", ""));
                return (baseNum3 / baseNum4) * pow(10, baseNum2 - baseNum1);
            }
        }
    });  
})(jQuery);