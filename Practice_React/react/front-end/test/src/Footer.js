import React,{Component} from 'react'
import style from './style/Footer.scss'
import classNames from "classnames/bind"

class Footer extends Component{
    render(){
        const cx =classNames.bind(style)
        return(
            <div className={cx('footer')}>
                <div className={cx('footerArea')}>
                    <div className={cx('contents')}>
                        <ul>
                            <li>사이트맵</li>
                            <li>대표자들</li>
                            <li>학과 주소</li>
                            <li>학과 번호</li>
                        </ul>
                    </div>
                    <div className={cx('result')}>
                        <ul>
                            <li> Career Us</li>
                            <li>김재훈 신규진 허준범</li>
                            <li>숭실대학교 형남공학관 424호</li>
                            <li>02-820-0950</li>
                        </ul>
                    </div>
                </div>
            </div>
        )
    }

}

export default Footer