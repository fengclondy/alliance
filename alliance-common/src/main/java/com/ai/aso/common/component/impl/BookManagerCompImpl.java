package com.ai.aso.common.component.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ai.aso.base.utils.StringUtil;
import com.ai.aso.common.bo.ContractBookBo;
import com.ai.aso.common.component.BookManagerComp;
import com.ai.aso.common.exception.BizExInfoEnum;
import com.ai.aso.common.exception.ContBookValidException;
import com.ai.aso.common.service.BookManagerService;

/**
 * 账本管理
 * <p>
 * Description:
 * </p>
 *
 * @author liuwu
 * @date 2016年9月29日
 *
 */
@Component
@Transactional
public class BookManagerCompImpl implements BookManagerComp {

	@Autowired
	private BookManagerService bookManagerService;

	@Override
	public String PaymentBookIncome(String amount, ContractBookBo bo) {
		if (null != bo) {
			if (StringUtil.isNotEmpty(bo.getContractBook().getContId())) {

				return bookManagerService.PaymentBookIncome(amount, bo);

			} else {

				throw new ContBookValidException();
			}
		} else {
			throw new ContBookValidException();
		}
	}

	@Override
	public String PaymentBookPay(String amount, ContractBookBo bo) {
		if (null != bo) {
			if (StringUtil.isNotEmpty(bo.getContractBook().getContId())) {

				return bookManagerService.PaymentBookPay(amount, bo);

			} else {

				throw new ContBookValidException();
			}
		} else {
			throw new ContBookValidException();
		}
	}

	@Override
	public String DepositBookIncome(String amount, ContractBookBo bo) {
		if (null != bo) {
			if (StringUtil.isNotEmpty(bo.getContractBook().getContId())) {

				return bookManagerService.DepositBookIncome(amount, bo);

			} else {

				throw new ContBookValidException();
			}
		} else {

			throw new ContBookValidException();
		}
	}

	@Override
	public String creditBookIncome(String amount, ContractBookBo bo) {
		if (null != bo) {
			if (StringUtil.isNotEmpty(bo.getContractBook().getContId())) {

				return bookManagerService.PaymentBookPay(amount, bo);

			} else {

				throw new ContBookValidException();
			}
		} else {

			throw new ContBookValidException();
		}
	}

	@Override
	public String creditBookPay(String amount, ContractBookBo bo) {
		if (null != bo) {
			if (StringUtil.isNotEmpty(bo.getContractBook().getContId())) {

				return bookManagerService.PaymentBookPay(amount, bo);

			} else {

				throw new ContBookValidException();
			}
		} else {

			throw new ContBookValidException();
		}
	}

	@Override
	public String creditBookOpen(String amount, ContractBookBo bo) {
		if (null != bo) {
			if (StringUtil.isNotEmpty(bo.getContractBook().getContId())) {

				return bookManagerService.PaymentBookOpen(amount, bo);
			} else {
				throw new ContBookValidException(BizExInfoEnum.CONTRACT_BOOK_ERROR);
			}
		} else {

			throw new ContBookValidException();
		}
	}

	@Override
	public String PaymentBookOpen(String amount, ContractBookBo bo) {
		if (null != bo) {
			if (StringUtil.isNotEmpty(bo.getContractBook().getContId())) {

				return bookManagerService.PaymentBookOpen(amount, bo);
			} else {
				throw new ContBookValidException(BizExInfoEnum.CONTRACT_BOOK_ERROR);
			}
		} else {

			throw new ContBookValidException();
		}
	}

	@Override
	public String DepositBookOpen(String amount, ContractBookBo bo) {
		if (null != bo) {
			if (StringUtil.isNotEmpty(bo.getContractBook().getContId())) {

				return bookManagerService.PaymentBookOpen(amount, bo);
				
			} else {
				throw new ContBookValidException(BizExInfoEnum.CONTRACT_BOOK_ERROR);
			}
		} else {

			throw new ContBookValidException();
		}
	}

}
