import './TodoList.css';
import TodoItem from './TodoItem';

const TodoList = () => {
    return (
        <div className="TodoList">
            <h3>TodoList 📋</h3>
            <input className="searchbar" placeholder="검색어를 입력하세요" />
            <div className='list_wrapper'>
                <TodoItem />
                <TodoItem />
                <TodoItem />
            </div>
        </div>
    );
}

export default TodoList;