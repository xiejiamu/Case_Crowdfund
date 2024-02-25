import React from 'react'
import { Menu } from 'element-react'

const Navbar = () => {
  return (
    <div className="navbar" style={{ marginBottom: '5rem'}}>
      <Menu style={{backgroundColor: 'rgb(5,9,18)' }} theme="dark" defaultActive="0" className="el-menu-demo" mode="horizontal">
        <div style={{marginRight: 'auto', display: 'flex'}}>
          <Menu.Item index="1">返回</Menu.Item>
        </div>
        
        <div style={{marginLeft: 'auto', display: 'flex'}}>
          <Menu.Item index="2">欢迎您，张云龙</Menu.Item>
          <Menu.Item index="3">我的</Menu.Item>
          <Menu.Item index="4">退出</Menu.Item>
          <Menu.Item index="5">意见建议</Menu.Item>
          <Menu.Item index="6">使用帮助</Menu.Item>
          <Menu.Item index="7"><i className="el-icon-message"></i></Menu.Item>
        </div>
      </Menu>
    </div>
  )
}

export default Navbar
