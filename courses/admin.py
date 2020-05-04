from django.contrib import admin
from .models import Course, Lesson


class CourseAdmin(admin.ModelAdmin):
    list_display = ('id', 'title')


admin.register(Course, CourseAdmin)
