from django.urls import path
from .views import *

urlpatterns = [
    path('/al/', CoursesViewSet.as_view()),
]