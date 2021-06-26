import React,{Component} from 'react'
import style from './style/Header.scss'
import classNames from "classnames/bind"

class Header extends Component{
    render(){
        const cx =classNames.bind(style); //내가 포함한 css파일의 스타일만 가져온다 
        return(
            <header className={cx('header')}>
                <div className={cx('contents')}>
                        <h1>Career Us</h1>
                </div>
                <nav className={cx('navigation')}>
                        <ul>
                            <li>
                               자유 게시판
                            </li>
                            <li>
                                프로필 목록
                            </li>
                            <li>
                               중고장터
                            </li>
                        </ul>
                </nav>
                <nav className={cx('signup')}>
                    <ul>
                        <li>
                            <a href="app.css">로그인</a>
                        </li>
                        <li>
                            <a href="app.css">로그아웃</a>
                        </li>
                    </ul>
                </nav>  
            </header>
        )
    } 
}

export default Header