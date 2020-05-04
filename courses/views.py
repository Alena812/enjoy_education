from django.shortcuts import render
from rest_framework import viewsets
from .serializers import *
from .models import *


class CoursesViewSet(viewsets.ModelViewSet):
    serializer_class = CourseSerializer
    queryset = Course.objects.all()
# Create your views here.
